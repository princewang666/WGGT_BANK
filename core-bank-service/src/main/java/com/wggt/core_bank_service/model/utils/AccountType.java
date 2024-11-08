package com.wggt.core_bank_service.model.utils;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "账户类型", description = "SAVINGS_ACCOUNT-储蓄账户,FIXED_DEPOSIT-定期存款,LOAN_ACCOUNT-贷款账户")
public enum AccountType {
    SAVINGS_ACCOUNT, FIXED_DEPOSIT, LOAN_ACCOUNT
}
