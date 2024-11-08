package com.wggt.core_bank_service.model.utils;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "交易类型", description = "FUND_TRANSFER-转账,UTILITY_PAYMENT-支付")
public enum TransactionType {
    FUND_TRANSFER, UTILITY_PAYMENT
}
