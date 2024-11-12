package com.wggt.core_bank_service.service;

import com.wggt.core_bank_service.model.dto.BankAccount;
import com.wggt.core_bank_service.model.dto.UtilityAccount;

public interface AccountService {
    /**
     * 根据卡号读取银行账户
     * @param accountNumber 卡号
     * @return BankAccount DTO形式
     */
    BankAccount readBankAccount(String accountNumber);
    /**
     * 根据公司名读取对公账号
     * @param provider 公司名
     * @return UtilityAccount DTO形式
     */
    UtilityAccount readUtilityAccount(String providerName);
    /**
     * 根据id读取对公账户
     * @param id id
     * @return UtilityAccount DTO形式
     */
    UtilityAccount readUtilityAccount(Long id);
}
