package com.rahansazeh.apiserver.model;

public class LoginRequest {
    private String userName;

    public LoginRequest(String userName) {
        this.userName = userName;
    }

    public LoginRequest() {
    }

    public String getUserName() {
        return userName;
    }
}
