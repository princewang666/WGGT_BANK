package com.wggt.bank_user_service.exception;

public class UserAlreadyRegisteredException extends WggtBankGlobalException {
    public UserAlreadyRegisteredException(String message, String code) {
        super(message, code);
    }
}
