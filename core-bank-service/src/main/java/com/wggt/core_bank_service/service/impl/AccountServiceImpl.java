package com.wggt.core_bank_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wggt.core_bank_service.exception.EntityNotFoundException;
import com.wggt.core_bank_service.mapper.BankAccountMapper;
import com.wggt.core_bank_service.mapper.UtilityAccountMapper;
import com.wggt.core_bank_service.model.dto.BankAccount;
import com.wggt.core_bank_service.model.dto.UtilityAccount;
import com.wggt.core_bank_service.model.entity.BankAccountEntity;
import com.wggt.core_bank_service.model.entity.UtilityAccountEntity;
import com.wggt.core_bank_service.model.mapper.BankAccountEntityDto;
import com.wggt.core_bank_service.model.mapper.UtilityAccountEntityDto;
import com.wggt.core_bank_service.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    // 将 BankAccount,UtilityAccount 从数据库的 Entity 转成 前端 DTO
    private BankAccountEntityDto bankAccountEntityDto = new BankAccountEntityDto();
    private UtilityAccountEntityDto utilityAccountEntityDto = new UtilityAccountEntityDto();

    @Autowired
    private BankAccountMapper bankAccountMapper;
    @Autowired
    private UtilityAccountMapper utilityAccountMapper;

    @Override
    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity entity = bankAccountMapper.findByNumber(accountNumber).orElseThrow(EntityNotFoundException::new);
        return bankAccountEntityDto.convertToDto(entity);
    }

    @Override
    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountMapper.findByProviderName(provider).orElseThrow(EntityNotFoundException::new);
        return utilityAccountEntityDto.convertToDto(utilityAccountEntity);
    }

    @Override
    public UtilityAccount readUtilityAccount(Long id) {
        return utilityAccountEntityDto.convertToDto(utilityAccountMapper.findById(id).orElseThrow(EntityNotFoundException::new));
    }
    
}
