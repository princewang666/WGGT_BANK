package com.wggt.core_bank_service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.wggt.core_bank_service.exception.EntityNotFoundException;
import com.wggt.core_bank_service.mapper.UserMapper;
import com.wggt.core_bank_service.model.dto.User;
import com.wggt.core_bank_service.model.entity.UserEntity;
import com.wggt.core_bank_service.model.mapper.UserEntityDto;
import com.wggt.core_bank_service.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    // 将 User 从数据库的 Entity 转成 前端 DTO
    private UserEntityDto userEntityDto = new UserEntityDto();

    @Autowired
    private UserMapper userMapper;

    @Override
    public User readUser(String identification) {
        UserEntity userEntity = userMapper.findByIdentificationNumber(identification).orElseThrow(EntityNotFoundException::new);
        return userEntityDto.convertToDto(userEntity);
    }

    @Override
    public List<User> readUsers(Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort().stream().map(order -> Cas))
        return userEntityDto.convertToDtoList(userMapper.findAll(pageable));
    }
}
