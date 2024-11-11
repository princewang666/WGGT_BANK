package com.wggt.core_bank_service.service;

import java.math.BigDecimal;

import com.wggt.core_bank_service.model.dto.BankAccount;
import com.wggt.core_bank_service.model.dto.request.FundTransferRequest;
import com.wggt.core_bank_service.model.dto.request.UtilityPaymentRequest;
import com.wggt.core_bank_service.model.dto.response.FundTransferResponse;
import com.wggt.core_bank_service.model.dto.response.UtilityPaymentResponse;

public interface TransactionService {
    /**
     * 转账请求
     * @param fundTransferRequest 转账请求体
     * @return 转账响应
     * 成功后会记录两笔记录，更新两个账户余额
     */
    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);
    /**
     * 支付请求
     * @param utilityPaymentRequest 支付请求体
     * @return 支付结果响应
     * 支付成功会记录单笔交易，更新支付账户的余额。被支付的公共账户不在本数据库做余额管理
     */
    UtilityPaymentResponse utilityPayment(UtilityPaymentRequest utilityPaymentRequest);



    // Service 内部调用方法

    /**
     * 验证账户余额是否足够
     * @param bankAccount 验证的账户
     * @param amount 资金数量
     * 如果账户现有余额小于资金数量，抛异常
     */
    void validateBalance(BankAccount bankAccount, BigDecimal amount);
    /**
     * 转账更新数据库方法
     * @param fromBankAccount 支付账户
     * @param toBankAccount 接收账户
     * @param amount 转账金额
     * @return 交易UUID
     * 成功会在数据库更新两个账户的金额信息
     * 会在交易表记录这两个账户的两笔交易
     */
    String internalFundTransfer(BankAccount fromBankAccount, BankAccount toBankAccount, BigDecimal amount);
}
