package com.wggt.bank_user_service.exception;

public class InvalidBankUserException extends WggtBankGlobalException {
    public InvalidBankUserException(String message, String code) {
        super(message, code);
    }
}
