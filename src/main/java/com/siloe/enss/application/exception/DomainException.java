package com.siloe.enss.application.exception;

public class DomainException extends RuntimeException {

    public DomainException() {
        super();
    }

    public DomainException(String message) {
        super(message);
    }
}