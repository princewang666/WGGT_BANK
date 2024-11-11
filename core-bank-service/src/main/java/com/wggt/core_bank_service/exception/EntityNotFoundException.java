package com.wggt.core_bank_service.exception;

public class EntityNotFoundException extends WggtBankGloabalException {
    public EntityNotFoundException() {
        super(GlobalErrorCode.ERROR_ENTITY_NOT_FOUND.getCode(), "Requested entity not present in the DB.");
    }

    public EntityNotFoundException(String message) {
        super(GlobalErrorCode.ERROR_ENTITY_NOT_FOUND.getCode(), message);
    }
}
