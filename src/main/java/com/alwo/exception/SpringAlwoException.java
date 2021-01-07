package com.alwo.exception;

public class SpringAlwoException extends RuntimeException {
    public SpringAlwoException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringAlwoException(String exMessage) {
        super(exMessage);
    }
}
