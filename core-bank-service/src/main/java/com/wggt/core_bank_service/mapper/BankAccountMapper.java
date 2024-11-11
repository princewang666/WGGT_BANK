package com.wggt.core_bank_service.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.BankAccountEntity;

@Mapper
public interface BankAccountMapper {
    Optional<BankAccountEntity> findByNumber(String accountNumber);

    boolean save(BankAccountEntity bankAccountEntity);
}
