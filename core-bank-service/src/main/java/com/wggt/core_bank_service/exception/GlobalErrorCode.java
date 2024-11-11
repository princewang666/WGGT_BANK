package com.wggt.core_bank_service.exception;

public enum GlobalErrorCode {
    ERROR_ENTITY_NOT_FOUND("CORE-BANK-SERVICE-1000"),
    INSUFFICIENT_FUNDS("CORE-BANK-SERVICE-1001");

    private String code;
    GlobalErrorCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
