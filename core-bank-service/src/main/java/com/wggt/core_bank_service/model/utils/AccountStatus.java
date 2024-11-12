package com.wggt.core_bank_service.model.utils;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "账户状态", description = "PENDING-挂起,ACTIVE-激活,DORMANT-休眠,BLOCKED-冻结")
public enum AccountStatus {
    PENDING, ACTIVE, DORMANT, BLOCKED
}
