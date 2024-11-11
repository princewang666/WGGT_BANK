package com.wggt.core_bank_service.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(title = "转账响应体")
public class FundTransferResponse {
    @Schema(name = "响应消息", example = "转账成功")
    private String message;
    @Schema(name = "交易ID", description = "交易ID(暂时不知)")
    private String transactionId;
}
