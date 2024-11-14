package com.wggt.bank_user_service.model.entity;

import com.wggt.bank_user_service.model.utils.UserStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户实体类", description = "关联core-bank-service的用户和Keycloak的用户")
public class UserEntity {
    @Schema(name = "记录ID", description = "唯一记录当前实体类", format = "int64", example = "1")
    private Long id;
    @Schema(name = "Auth ID", description = "关联 Keycloak 用户表")
    private String authId;
    @Schema(name = "识别码", description = "关联 core-bank-service 用户")
    private String identification;
    @Schema(name = "用户状态", implementation = UserStatus.class)
    private UserStatus status;
}
