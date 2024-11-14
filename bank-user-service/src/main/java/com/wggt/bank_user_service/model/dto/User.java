package com.wggt.bank_user_service.model.dto;

import com.wggt.bank_user_service.model.utils.UserStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户传输 DTO 类", description = "前端传入用于创建用户")
public class User {
    @Schema(name = "用户ID", format = "int64", example = "1")
    private Long id;
    @Schema(name = "用户邮件", example = "11115555@qq.com")
    private String email;
    @Schema(name = "识别码", description = "通过识别码查找用户")
    private String identification;
    @Schema(name = "用户密码", example = "1234")
    private String password;
    @Schema(name = "Auth ID", description = "与 Keycloak 用户表相关联")
    private String authId;
    @Schema(name = "用户状态", implementation = UserStatus.class)
    private UserStatus status;
}
