/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 16:40:07
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 17:19:21
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\entity\BankAccountEntity.java
 * @Description: 银行账户实体类
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "银行个人账户实体类")
public class BankAccountEntity {
    @Schema(name = "账户ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "账户号", example = "6000100080007000300")
    private String number;
    @Schema(name = "账户类型", implementation = AccountType.class)
    private AccountType type;
    @Schema(name = "账户状态", implementation = AccountStatus.class)
    private AccountStatus status;
    @Schema(name = "可用余额", implementation = BigDecimal.class)
    private BigDecimal availableBalance;
    @Schema(name = "实际余额", implementation = BigDecimal.class)
    private BigDecimal actualBalance;

    @Schema(name = "所属用户", implementation = UserEntity.class)
    private UserEntity user;
}
