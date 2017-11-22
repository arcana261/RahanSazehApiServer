package com.rahansazeh.apiserver.controller;

public class Response<T> {
    private boolean status;
    private String description;
    private T data;

    private Response(boolean status, String description, T data) {
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public T getData() {
        return data;
    }

    public static <Type> Response<Type> success(Type data) {
        return new Response<>(true, null, data);
    }

    public static <Type> Response<Type> error(Exception err) {
        return new Response<>(false, err.getMessage(), null);
    }
}
