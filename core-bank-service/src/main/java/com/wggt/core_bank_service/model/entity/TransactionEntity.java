/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 17:27:56
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 17:38:49
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\entity\TransactionEntity.java
 * @Description: 交易记录实体
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "交易记录实体类")
public class TransactionEntity {
    @Schema(name = "交易记录ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "交易金额", implementation = BigDecimal.class)
    private BigDecimal amount;
    @Schema(name = "交易类型", implementation = TransactionType.class)
    private TransactionType transactionType;
    @Schema(name = "参考号", description = "参考号(暂时不知)")
    private String referenceNumber;
    @Schema(name = "交易ID", description = "交易ID(暂时不知)")
    private String transactionId;
    @Schema(name = "用户账户", implementation = BankAccountEntity.class)
    private BankAccountEntity account;
}
