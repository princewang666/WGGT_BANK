package com.wggt.core_bank_service.service.impl;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wggt.core_bank_service.exception.EntityNotFoundException;
import com.wggt.core_bank_service.exception.GlobalErrorCode;
import com.wggt.core_bank_service.exception.InsufficientFundsException;
import com.wggt.core_bank_service.mapper.BankAccountMapper;
import com.wggt.core_bank_service.mapper.TransactionMapper;
import com.wggt.core_bank_service.model.dto.BankAccount;
import com.wggt.core_bank_service.model.dto.UtilityAccount;
import com.wggt.core_bank_service.model.dto.request.FundTransferRequest;
import com.wggt.core_bank_service.model.dto.request.UtilityPaymentRequest;
import com.wggt.core_bank_service.model.dto.response.FundTransferResponse;
import com.wggt.core_bank_service.model.dto.response.UtilityPaymentResponse;
import com.wggt.core_bank_service.model.entity.BankAccountEntity;
import com.wggt.core_bank_service.model.entity.TransactionEntity;
import com.wggt.core_bank_service.model.utils.TransactionType;
import com.wggt.core_bank_service.service.AccountService;
import com.wggt.core_bank_service.service.TransactionService;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private AccountService accountService;
    @Autowired
    private BankAccountMapper bankAccountMapper;
    @Autowired
    private TransactionMapper transactionMapper;

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        BankAccount fromBankAccount = accountService.readBankAccount(fundTransferRequest.getFromAccount());
        BankAccount toBankAccount = accountService.readBankAccount(fundTransferRequest.getToAccount());

        //validating account balances
        validateBalance(fromBankAccount, fundTransferRequest.getAmount());

        String transactionId = internalFundTransfer(fromBankAccount, toBankAccount, fundTransferRequest.getAmount());
        return FundTransferResponse.builder().message("Transaction successfully completed").transactionId(transactionId).build();
    }

    @Override
    public UtilityPaymentResponse utilityPayment(UtilityPaymentRequest utilityPaymentRequest) {
        String transactionId = UUID.randomUUID().toString();

        BankAccount fromBankAccount = accountService.readBankAccount(utilityPaymentRequest.getAccount());

        //validating account balances
        validateBalance(fromBankAccount, utilityPaymentRequest.getAmount());

        UtilityAccount utilityAccount = accountService.readUtilityAccount(utilityPaymentRequest.getProviderId());

        BankAccountEntity fromAccount = bankAccountMapper.findByNumber(fromBankAccount.getNumber()).get();

        //we can call third party API to process UTIL payment from payment provider from here.
        utilityAccount.getNumber();  // 第三方账户金额增加，在这里没有编写

        fromAccount.setActualBalance(fromAccount.getActualBalance().subtract(utilityPaymentRequest.getAmount()));
        fromAccount.setAvailableBalance(fromAccount.getAvailableBalance().subtract(utilityPaymentRequest.getAmount()));
        bankAccountMapper.save(fromAccount);

        transactionMapper.insert(TransactionEntity.builder().transactionType(TransactionType.UTILITY_PAYMENT)
            .accountId(fromAccount.getId())
            .transactionId(transactionId)
            .referenceNumber(utilityPaymentRequest.getReferenceNumber())
            .amount(utilityPaymentRequest.getAmount().negate())
            .account(fromAccount).build());

        return UtilityPaymentResponse.builder().message("Utility payment successfully completed")
            .transactionId(transactionId).build();
    }

    @Override
    public void validateBalance(BankAccount bankAccount, BigDecimal amount) {
        if (bankAccount.getActualBalance().compareTo(BigDecimal.ZERO) < 0 || bankAccount.getActualBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException(GlobalErrorCode.INSUFFICIENT_FUNDS.getCode(), "Insufficient funds in the account " + bankAccount.getNumber());
        }
    }

    @Override
    public String internalFundTransfer(BankAccount fromBankAccount, BankAccount toBankAccount, BigDecimal amount) {
        String transactionId = UUID.randomUUID().toString();

        BankAccountEntity fromBankAccountEntity = bankAccountMapper.findByNumber(fromBankAccount.getNumber()).orElseThrow(EntityNotFoundException::new);
        BankAccountEntity toBankAccountEntity = bankAccountMapper.findByNumber(toBankAccount.getNumber()).orElseThrow(EntityNotFoundException::new);

        fromBankAccountEntity.setActualBalance(fromBankAccountEntity.getActualBalance().subtract(amount));
        fromBankAccountEntity.setAvailableBalance(fromBankAccountEntity.getAvailableBalance().subtract(amount));
        bankAccountMapper.save(fromBankAccountEntity);

        transactionMapper.insert(TransactionEntity.builder().transactionType(TransactionType.FUND_TRANSFER)
            .referenceNumber(toBankAccountEntity.getNumber())
            .transactionId(transactionId)
            .accountId(fromBankAccountEntity.getId())
            .amount(amount.negate())
            .account(fromBankAccountEntity).build());

        toBankAccountEntity.setActualBalance(toBankAccountEntity.getActualBalance().add(amount));
        toBankAccountEntity.setAvailableBalance(toBankAccountEntity.getAvailableBalance().add(amount));
        bankAccountMapper.save(toBankAccountEntity);

        transactionMapper.insert(TransactionEntity.builder().transactionType(TransactionType.FUND_TRANSFER)
            .referenceNumber(toBankAccountEntity.getNumber())
            .transactionId(transactionId)
            .accountId(toBankAccountEntity.getId())
            .amount(amount)
            .account(toBankAccountEntity).build());

        return transactionId;
    }
    
}
