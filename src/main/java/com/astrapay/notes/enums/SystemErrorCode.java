package com.astrapay.notes.enums;

public enum SystemErrorCode {
    E4001_NOT_FOUND("E4001", "Entity not found in memory store."),

    E4002_INVALID_INPUT("E4002", "Input request failed validation checks."),

    E5000_INTERNAL_ERROR("E5000", "An unexpected internal error occurred.");

    private final String code;
    private final String message;

    SystemErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}