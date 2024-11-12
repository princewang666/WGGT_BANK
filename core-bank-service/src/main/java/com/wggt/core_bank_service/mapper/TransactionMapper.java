package com.wggt.core_bank_service.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.TransactionEntity;

@Mapper
public interface TransactionMapper {
    boolean save(TransactionEntity transactionEntity);
}
