package com.wggt.bank_user_service.model.utils;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(title = "用户状态", description = "PENDING-正常,APPROVED-批准,DISABLED-封禁,BLACKLIST-黑名单")
public enum UserStatus {
    PENDING, APPROVED, DISABLED, BLACKLIST
}
