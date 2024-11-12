package com.wggt.core_bank_service.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.UserEntity;

@Mapper
public interface UserMapper {
    Optional<UserEntity> findByIdentificationNumber(String identificationNumber);
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findAll();
}
