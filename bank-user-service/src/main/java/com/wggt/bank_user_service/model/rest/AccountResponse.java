package com.wggt.bank_user_service.model.rest;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "账户响应类", description = "对应core-bank-service的BankAccount DTO")
public class AccountResponse {
    @Schema(name = "账户号", example = "6000100080007000300")
    private String number;
    @Schema(name = "实际余额", implementation = BigDecimal.class)
    private BigDecimal actualBalance;
    @Schema(name = "账户ID", format = "int32", example = "1")
    private Integer id;
    @Schema(name = "账户类型", example = "SAVINGS_ACCOUNT")
    private String type;
    @Schema(name = "账户状态", example = "ACTIVE")
    private String status;
    @Schema(name = "可用余额", implementation = BigDecimal.class)
    private BigDecimal availableBalance;
}
