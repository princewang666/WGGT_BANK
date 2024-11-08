package com.wggt.core_bank_service.model.mapper;

import org.springframework.beans.BeanUtils;

import com.wggt.core_bank_service.model.dto.BankAccount;
import com.wggt.core_bank_service.model.entity.BankAccountEntity;

public class BankAccountEntityDto extends BaseMapper<BankAccountEntity, BankAccount> {

    @Override
    public BankAccountEntity convertToEntity(BankAccount dto) {
        BankAccountEntity entity = new BankAccountEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity, "user");
        }
        return entity;
    }

    @Override
    public BankAccount convertToDto(BankAccountEntity entity) {
        BankAccount dto = new BankAccount();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "user");
        }
        return dto;
    }
    
}
