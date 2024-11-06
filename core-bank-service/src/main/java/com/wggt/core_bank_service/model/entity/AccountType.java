/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 16:43:32
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 16:54:15
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\mapper\AccountType.java
 * @Description: 账户类型
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "账户类型", description = "SAVINGS_ACCOUNT-储蓄账户,FIXED_DEPOSIT-定期存款,LOAN_ACCOUNT-贷款账户")
public enum AccountType {
    SAVINGS_ACCOUNT, FIXED_DEPOSIT, LOAN_ACCOUNT
}
