package com.wggt.core_bank_service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.CaseFormat;
import com.wggt.core_bank_service.exception.EntityNotFoundException;
import com.wggt.core_bank_service.mapper.BankAccountMapper;
import com.wggt.core_bank_service.mapper.UserMapper;
import com.wggt.core_bank_service.model.dto.User;
import com.wggt.core_bank_service.model.entity.BankAccountEntity;
import com.wggt.core_bank_service.model.entity.UserEntity;
import com.wggt.core_bank_service.model.mapper.UserEntityDto;
import com.wggt.core_bank_service.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    // 将 User 从数据库的 Entity 转成 前端 DTO
    private UserEntityDto userEntityDto = new UserEntityDto();

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BankAccountMapper bankAccountMapper;

    @Override
    public User readUser(String identificationNumber) {
        UserEntity userEntity = userMapper.findByIdentificationNumber(identificationNumber).orElseThrow(EntityNotFoundException::new);
        List<BankAccountEntity> bankAccounts = bankAccountMapper.findByUserId(userEntity.getId());
        userEntity.setAccounts(bankAccounts);
        return userEntityDto.convertToDto(userEntity);
    }

    @Override
    public User readUser(Long id) {
        UserEntity userEntity = userMapper.findById(id).orElseThrow(EntityNotFoundException::new);
        List<BankAccountEntity> bankAccounts = bankAccountMapper.findByUserId(userEntity.getId());
        userEntity.setAccounts(bankAccounts);
        return userEntityDto.convertToDto(userEntity);
    }

    @Override
    public List<User> readUsers(Pageable pageable) {
        // Pageable(JPA) 转成 PageHelper(Mybatis)
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), 
            pageable.getSort().stream().map(order -> CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, order.getProperty()) + " " + order.getDirection()).collect(Collectors.joining(",")));
        List<UserEntity> allUsers = userMapper.findAll();
        // * 可能会影响查找速度
        for (UserEntity userEntity : allUsers) {
            List<BankAccountEntity> bankAccounts = bankAccountMapper.findByUserId(userEntity.getId());
            userEntity.setAccounts(bankAccounts);
        }
        PageInfo<UserEntity> pageInfo = new PageInfo<>(allUsers);
        return userEntityDto.convertToDtoList(pageInfo.getList());
    }
}
