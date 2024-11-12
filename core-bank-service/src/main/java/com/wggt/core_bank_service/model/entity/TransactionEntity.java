/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 17:27:56
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-12 11:17:51
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\entity\TransactionEntity.java
 * @Description: 交易记录实体
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import java.math.BigDecimal;

import com.wggt.core_bank_service.model.utils.TransactionType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "交易记录实体类")
public class TransactionEntity {
    @Schema(name = "交易记录ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "交易金额", description = "正代表收入，负代表支出", implementation = BigDecimal.class)
    private BigDecimal amount;
    @Schema(name = "交易类型", implementation = TransactionType.class)
    private TransactionType transactionType;
    @Schema(name = "参考卡号", description = "接收用户卡号")
    private String referenceNumber;
    @Schema(name = "交易ID", description = "每笔交易对应的UUID")
    private String transactionId;
    @Schema(name = "用户账户id", description = "支出/接收用户", format = "int64", example = "1")
    private Long accountId;

    
    @Schema(name = "用户账户", description = "支出/接收用户", implementation = BankAccountEntity.class)
    private BankAccountEntity account;
}
