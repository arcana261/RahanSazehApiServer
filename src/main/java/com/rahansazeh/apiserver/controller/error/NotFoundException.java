package com.rahansazeh.apiserver.controller.error;

public class NotFoundException extends Exception {
    public NotFoundException(String message) {
        super(message);
    }
}
