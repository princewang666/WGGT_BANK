package com.wggt.core_bank_service.exception;

public class InsufficientFundsException extends WggtBankGloabalException{
    public InsufficientFundsException(String code, String message) {
        super(code, message);
    }
}
