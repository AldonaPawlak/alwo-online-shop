package com.alwo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Entity already exist")
public class ConflictException extends RuntimeException {
    public ConflictException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public ConflictException(String exMessage) {
        super(exMessage);
    }
}
