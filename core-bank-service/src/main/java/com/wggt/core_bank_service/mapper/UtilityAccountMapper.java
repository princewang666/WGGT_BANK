/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-07 15:45:28
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-11 16:03:09
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\mapper\UtilityAccountMapper.java
 * @Description: 
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.UtilityAccountEntity;

@Mapper
public interface UtilityAccountMapper {
    Optional<UtilityAccountEntity> findByProviderName(String provider);
    Optional<UtilityAccountEntity> findById(Long id);
}
