package com.wggt.bank_user_service.service;

import java.util.Collections;
import java.util.List;

import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wggt.bank_user_service.exception.GlobalErrorCode;
import com.wggt.bank_user_service.exception.InvalidBankUserException;
import com.wggt.bank_user_service.exception.InvalidEmailException;
import com.wggt.bank_user_service.exception.UserAlreadyRegisteredException;
import com.wggt.bank_user_service.mapper.UserMapper;
import com.wggt.bank_user_service.model.dto.User;
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

        // 不存在通过 Feign 读取core-bank-service用户，判断是否已存在
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
            // 用户设置的密码信息
            CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
            credentialRepresentation.setValue(user.getPassword());
            credentialRepresentation.setTemporary(false);
            userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

            // 创建用户
            Integer userCreationResponse = keycloakUserService.createUser(userRepresentation);

            if (userCreationResponse == 201) {
                // 创建成功后读取 Keycloak 数据库中的 AuthID，存到本地
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
}
