/*
 * @Author: princewang666 1213246620@qq.com
 * @Date: 2024-11-06 16:48:08
 * @LastEditors: princewang666 1213246620@qq.com
 * @LastEditTime: 2024-11-06 17:04:00
 * @FilePath: \WGGT_BANK\core-bank-service\src\main\java\com\wggt\core_bank_service\model\mapper\AccountStatus.java
 * @Description: 账户状态
 * 
 * Copyright (c) 2024 by wggt, All Rights Reserved. 
 */
package com.wggt.core_bank_service.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "账户状态", description = "PENDING-挂起,ACTIVE-激活,DORMANT-休眠,BLOCKED-冻结")
public enum AccountStatus {
    PENDING, ACTIVE, DORMANT, BLOCKED
}
