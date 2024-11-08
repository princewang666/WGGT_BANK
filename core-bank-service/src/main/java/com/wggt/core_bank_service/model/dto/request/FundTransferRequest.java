package com.wggt.core_bank_service.model.dto.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "转账请求体")
public class FundTransferRequest {
    @Schema(name = "转账账户", example = "6000100080007000300")
    private String fromAccount;
    @Schema(name = "收款账户", example = "6000100080007000301")
    private String toAccount;
    @Schema(name = "转账金额", implementation = BigDecimal.class)
    private BigDecimal amount;
}
