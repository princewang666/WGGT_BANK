package com.wggt.bank_user_service.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.bank_user_service.model.entity.UserEntity;

@Mapper
public interface UserMapper {
    boolean insert(UserEntity userEntity);
}
