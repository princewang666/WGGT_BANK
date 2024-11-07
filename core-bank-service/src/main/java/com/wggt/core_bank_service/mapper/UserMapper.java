/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-07 14:23:13
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-07 15:43:35
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\mapper\UserMapper.java
 * @Description: 
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.UserEntity;

@Mapper
public interface UserMapper {
    Optional<UserEntity> findByIdentificationNumber(String identificationNumber);
}
