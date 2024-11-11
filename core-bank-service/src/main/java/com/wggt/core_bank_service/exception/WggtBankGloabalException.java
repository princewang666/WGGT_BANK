package com.wggt.core_bank_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
// Data 不包含 AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class WggtBankGloabalException extends RuntimeException {
    // 异常状态码
    private String code;
    // 异常状态信息
    private String message;
    
    public WggtBankGloabalException(String message) {
        super(message);
    }
}