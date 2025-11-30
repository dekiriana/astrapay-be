package com.astrapay.notes.exception;

import com.astrapay.notes.enums.SystemErrorCode;

public class NoteNotFoundException extends RuntimeException {

    private final SystemErrorCode errorCode;
    public NoteNotFoundException(String message, SystemErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public SystemErrorCode getErrorCode() {
        return errorCode;
    }
}