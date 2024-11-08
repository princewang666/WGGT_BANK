package com.wggt.core_bank_service.model.dto.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "支付请求体")
public class UtilityPaymentRequest {
    @Schema(name = "对公账户ID", format = "int64", example = "1")
    private Long providerId;
    @Schema(name = "支付金额", implementation = BigDecimal.class)
    private BigDecimal amount;
    @Schema(name = "参考号", description = "参考号(暂时不知)")
    private String referenceNumber;
    @Schema(name = "收款账户", example = "6000100080007000301")
    private String account;
}
