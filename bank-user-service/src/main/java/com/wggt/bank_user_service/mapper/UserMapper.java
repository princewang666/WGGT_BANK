package com.wggt.bank_user_service.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.bank_user_service.model.entity.UserEntity;

@Mapper
public interface UserMapper {
    boolean insert(UserEntity userEntity);
    List<UserEntity> findAll();
    Optional<UserEntity> findById(Long id);
    boolean update(UserEntity userEntity);
}
