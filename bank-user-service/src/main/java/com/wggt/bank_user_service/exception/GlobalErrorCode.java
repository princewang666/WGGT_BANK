package com.wggt.bank_user_service.exception;

public enum GlobalErrorCode {
    ERROR_ENTITY_NOT_FOUND("USER-SERVICE-1000"),
    ERROR_EMAIL_REGISTERED("USER-SERVICE-1001"),
    ERROR_INVALID_EMAIL("USER-SERVICE-1002"),
    ERROR_USER_NOT_FOUND_UNDER_NIC("USER-SERVICE-1003");

    private String code;
    GlobalErrorCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
