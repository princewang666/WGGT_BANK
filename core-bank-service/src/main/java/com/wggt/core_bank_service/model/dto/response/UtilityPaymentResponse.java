package com.wggt.core_bank_service.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "支付响应体")
public class UtilityPaymentResponse {
    @Schema(name = "响应消息", example = "支付成功")
    private String message;
    @Schema(name = "交易ID", description = "交易ID(暂时不知)")
    private String transactionId;
}
