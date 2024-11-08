package com.wggt.core_bank_service.model.dto;

import java.math.BigDecimal;

import com.wggt.core_bank_service.model.utils.AccountStatus;
import com.wggt.core_bank_service.model.utils.AccountType;

import lombok.Data;

@Data
public class BankAccount {
    private Long id;
    private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private User user;
}
