package com.wggt.bank_user_service.model.rest;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "用户响应类", description = "对应core-bank-service的User DTO")
public class UserResponse {
    @Schema(name = "用户名", example = "Donald")
    private String firstName;
    @Schema(name = "用户姓", example = "Trump")
    private String lastName;
    @Schema(name = "用户账户", description = "用户名下的所有账户(List类型)", type = "array", example = "[AccountResponse1, AccountResponse2]", implementation = AccountResponse.class)
    private List<AccountResponse> bankAccounts;
    @Schema(name = "识别码", description = "用于识别用户")
    private String identificationNumber;
    @Schema(name = "用户ID", format = "int32", example = "1")
    private Integer id;
    @Schema(name = "邮件", example = "11115555@qq.com")
    private String email;
}
