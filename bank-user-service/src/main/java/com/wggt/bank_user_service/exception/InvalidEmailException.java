package com.wggt.bank_user_service.exception;

public class InvalidEmailException extends WggtBankGlobalException{
    public InvalidEmailException(String message, String code) {
        super(message, code);
    }
}
