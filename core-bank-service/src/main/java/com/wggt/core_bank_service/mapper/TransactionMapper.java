/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-07 15:46:33
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-07 17:14:55
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\mapper\TransactionMapper.java
 * @Description: 
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.TransactionEntity;

@Mapper
public interface TransactionMapper {
    boolean save(TransactionEntity transactionEntity);
}
