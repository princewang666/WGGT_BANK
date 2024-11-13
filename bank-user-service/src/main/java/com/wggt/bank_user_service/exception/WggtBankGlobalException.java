package com.wggt.bank_user_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
// Data 不包含 AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class WggtBankGlobalException extends RuntimeException {
    // 异常状态信息
    private String message;
    // 异常状态码
    private String code;
    
    public WggtBankGlobalException(String message) {
        super(message);
    }
}