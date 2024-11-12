package com.wggt.core_bank_service.model.dto.request;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "支付请求体")
public class UtilityPaymentRequest {
    @Schema(name = "公共账户ID", format = "int64", example = "1")
    private Long providerId;
    @Schema(name = "支付金额", implementation = BigDecimal.class)
    private BigDecimal amount;
    @Schema(name = "公共账户卡号", example = "6000100080007000308")
    private String referenceNumber;
    @Schema(name = "支付账户", example = "6000100080007000301")
    private String account;
}
