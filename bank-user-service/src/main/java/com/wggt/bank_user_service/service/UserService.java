package com.wggt.bank_user_service.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.CaseFormat;
import com.wggt.bank_user_service.exception.EntityNotFoundException;
import com.wggt.bank_user_service.exception.GlobalErrorCode;
import com.wggt.bank_user_service.exception.InvalidBankUserException;
import com.wggt.bank_user_service.exception.InvalidEmailException;
import com.wggt.bank_user_service.exception.UserAlreadyRegisteredException;
import com.wggt.bank_user_service.mapper.UserMapper;
import com.wggt.bank_user_service.model.dto.User;
import com.wggt.bank_user_service.model.dto.request.UserUpdateRequest;
import com.wggt.bank_user_service.model.entity.UserEntity;
import com.wggt.bank_user_service.model.mapper.UserEntityDto;
import com.wggt.bank_user_service.model.rest.UserResponse;
import com.wggt.bank_user_service.model.utils.UserStatus;
import com.wggt.bank_user_service.service.rest.CoreBankServiceRestClient;

@Service
public class UserService {
    @Autowired
    private KeycloakUserService keycloakUserService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CoreBankServiceRestClient coreBankServiceRestClient;

    private UserEntityDto userEntityDto = new UserEntityDto();

    public User creatUser(User user) {
        // 先根据 email 读取 Keycloak 数据库，判断是否已存在
        List<UserRepresentation> userRepresentations = keycloakUserService.readUserByEmail(user.getEmail());
        if (!userRepresentations.isEmpty()) {
            throw new UserAlreadyRegisteredException("This email already registered as a user. Please check and retry.", GlobalErrorCode.ERROR_EMAIL_REGISTERED.getCode());
        }

        // 不存在通过 Feign 读取core-bank-service用户，判断是否存在
        UserResponse userResponse = coreBankServiceRestClient.readUser(user.getIdentification());

        if (userResponse.getId() != null) {
            // core-bank-service存在

            // 判断是否 email 不相等
            if (!userResponse.getEmail().equals(user.getEmail())) {
                throw new InvalidEmailException("Incorrect email. Please check and retry.", GlobalErrorCode.ERROR_INVALID_EMAIL.getCode());
            }

            // 将core-bank-service用户同步到 Keycloak 数据库
            UserRepresentation userRepresentation = new UserRepresentation();
            userRepresentation.setEmail(userResponse.getEmail());
            userRepresentation.setEmailVerified(false);
            userRepresentation.setEnabled(false);
            userRepresentation.setUsername(userResponse.getEmail());
            userRepresentation.setFirstName(userResponse.getFirstName());
            userRepresentation.setLastName(userResponse.getLastName());
            // 将用户设置的密码添加到 Keycloak 数据库
            CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
            credentialRepresentation.setValue(user.getPassword());
            credentialRepresentation.setTemporary(false);
            userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

            // 在 Keycloak 数据库创建用户
            Integer userCreationResponse = keycloakUserService.createUser(userRepresentation);

            if (userCreationResponse == 201) {
                // 创建成功后读取 Keycloak 数据库中的 AuthID，存到本地映射表
                List<UserRepresentation> userRepresentations1 = keycloakUserService.readUserByEmail(user.getEmail());
                user.setAuthId(userRepresentations1.get(0).getId());
                user.setStatus(UserStatus.PENDING);
                user.setIdentification(userResponse.getIdentificationNumber());
                UserEntity newUser = userEntityDto.convertToEntity(user);
                userMapper.insert(newUser);
                return userEntityDto.convertToDto(newUser);
            }
        }
        // core-bank-service不存在该用户，抛异常
        throw new InvalidBankUserException("We couldn't find user under given identification. Please check and retry", GlobalErrorCode.ERROR_USER_NOT_FOUND_UNDER_NIC.getCode());   
    }

    public List<User> readUsers(Pageable pageable) {

        // Pageable(JPA) 转成 PageHelper(Mybatis)
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), 
            pageable.getSort().stream().map(order -> CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, order.getProperty()) + " " + order.getDirection()).collect(Collectors.joining(",")));
        List<UserEntity> allUsers = userMapper.findAll();
       
        PageInfo<UserEntity> pageInfo = new PageInfo<>(allUsers);
        List<User> users = userEntityDto.convertToDtoList(pageInfo.getList());
        // ? 貌似没意义呀，就用了哥远程email
        users.forEach(user -> {
            UserRepresentation userRepresentation = keycloakUserService.readUser(user.getAuthId());
            user.setId(user.getId());
            user.setEmail(userRepresentation.getEmail());
            user.setIdentification(user.getIdentification());
        });
        return users;
    }

    public User readUser(Long id) {
        return userEntityDto.convertToDto(userMapper.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public User updateUser(Long id, UserUpdateRequest userUpdateRequest) {
        UserEntity userEntity = userMapper.findById(id).orElseThrow(EntityNotFoundException::new);

        // 当用户把状态改为授权时，需要验证用户和邮箱，更新 Keycloak 状态
        if (userUpdateRequest.getStatus() == UserStatus.APPROVED) {
            UserRepresentation userRepresentation = keycloakUserService.readUser(userEntity.getAuthId());
            userRepresentation.setEnabled(true);
            userRepresentation.setEmailVerified(true);
            keycloakUserService.updateUser(userRepresentation);
        }
        // 其它情况只更新本地关联表用户状态
        userEntity.setStatus(userUpdateRequest.getStatus());
        userMapper.update(userEntity);
        return userEntityDto.convertToDto(userEntity);
    }
}
