package com.wggt.bank_user_service.exception;

public class EntityNotFoundException extends WggtBankGlobalException{
    public EntityNotFoundException() {
        super("Requested entity not present in the DB.", GlobalErrorCode.ERROR_ENTITY_NOT_FOUND.getCode());
    }

    public EntityNotFoundException(String message) {
        super(message, GlobalErrorCode.ERROR_ENTITY_NOT_FOUND.getCode());
    }
}
