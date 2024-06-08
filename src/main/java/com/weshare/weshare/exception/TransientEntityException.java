package com.weshare.weshare.exception;

public class TransientEntityException extends RuntimeException {
    public TransientEntityException(String message) {
        super(message);
    }
}