package com.wggt.core_bank_service.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.wggt.core_bank_service.model.entity.UtilityAccountEntity;

@Mapper
public interface UtilityAccountMapper {
    Optional<UtilityAccountEntity> findByProviderName(String providerName);
    Optional<UtilityAccountEntity> findById(Long id);
}
