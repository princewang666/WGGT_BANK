package com.wggt.core_bank_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wggt.core_bank_service.model.dto.BankAccount;
import com.wggt.core_bank_service.model.dto.UtilityAccount;
import com.wggt.core_bank_service.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/account")
@Tag(name = "Account API", description = "账户查询接口")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Operation(summary = "根据卡号读取个人账户", description = "提供卡号，返回查询到的银行账户", 
    parameters = {
        @Parameter(name = "accountNumber", description = "卡号", required = true, example = "6000100080007000300")
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "根据卡号读取个人账户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "BankAccount", description = "BankAccount DTO模型", implementation = BankAccount.class)))
    })
    @GetMapping("/bank-account/{account_number}")
    public ResponseEntity<BankAccount> getBankAccount(@PathVariable("account_number") String accountNumber) {
        return ResponseEntity.ok(accountService.readBankAccount(accountNumber));
    }

    @Operation(summary = "根据公司名读取公共账户", description = "提供公司名，返回查询到的公共账户", 
    parameters = {
        @Parameter(name = "providerName", description = "公司名", required = true, example = "淘宝网")
    }, 
    responses = {
        @ApiResponse(responseCode = "200", description = "根据公司名读取公共账户成功", 
            content = @Content(mediaType = "application/json", schema = @Schema(title = "UtilityAccount", description = "UtilityAccount DTO模型", implementation = UtilityAccount.class)))
    })
    @GetMapping("/util-account/{account_name}")
    public ResponseEntity<UtilityAccount> getUtilityAccount(@PathVariable("account_name") String providerName) {
        return ResponseEntity.ok(accountService.readUtilityAccount(providerName));
    }
}
