package com.wggt.core_bank_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wggt.core_bank_service.model.dto.request.FundTransferRequest;
import com.wggt.core_bank_service.model.dto.request.UtilityPaymentRequest;
import com.wggt.core_bank_service.model.dto.response.FundTransferResponse;
import com.wggt.core_bank_service.model.dto.response.UtilityPaymentResponse;
import com.wggt.core_bank_service.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/transaction")
@Tag(name = "Transaction API", description = "支付/转账接口")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "发起转账请求", description = "提供支付账户、接收账户、转账额度，发起转账", 
    parameters = {
        @Parameter(name = "FundTransferRequest", description = "转账请求体", required = true,
            schema = @Schema(title = "FundTransferRequest", implementation = FundTransferRequest.class))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "转账成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "FundTransferResponse", description = "转账响应体", implementation = FundTransferResponse.class)))
    })
    @PostMapping("/fund-transfer")
    public ResponseEntity<FundTransferResponse> fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));
    }

    @Operation(summary = "发起支付请求", description = "提供公共账户id/公司名、支付账户、支付额度，发起支付", 
    parameters = {
        @Parameter(name = "UtilityPaymentRequest", description = "支付请求体", required = true,
            schema = @Schema(title = "UtilityPaymentRequest", implementation = UtilityPaymentRequest.class))
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "支付成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "UtilityPaymentResponse", description = "支付响应体", implementation = UtilityPaymentResponse.class)))
    })
    @PostMapping("/util-payment")
    public ResponseEntity<UtilityPaymentResponse> utilityPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {
        return ResponseEntity.ok(transactionService.utilityPayment(utilityPaymentRequest));
    }
}
