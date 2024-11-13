package com.wggt.bank_user_service.model.dto.request;

import com.wggt.bank_user_service.model.utils.UserStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户更新请求类")
public class UserUpdateRequest {
    @Schema(name = "用户状态", implementation = UserStatus.class)
    private UserStatus status;
}
