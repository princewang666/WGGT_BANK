package com.wggt.core_bank_service.model.mapper;

import org.springframework.beans.BeanUtils;

import com.wggt.core_bank_service.model.dto.UtilityAccount;
import com.wggt.core_bank_service.model.entity.UtilityAccountEntity;

public class UtilityAccountEntityDto extends BaseMapper<UtilityAccountEntity, UtilityAccount> {

    @Override
    public UtilityAccountEntity convertToEntity(UtilityAccount dto) {
        UtilityAccountEntity entity = new UtilityAccountEntity();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    @Override
    public UtilityAccount convertToDto(UtilityAccountEntity entity) {
        UtilityAccount dto = new UtilityAccount();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }
    
}
