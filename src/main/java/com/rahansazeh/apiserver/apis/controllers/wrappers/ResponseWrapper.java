package com.rahansazeh.apiserver.apis.controllers.wrappers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class ResponseWrapper<T> {
    @ApiModelProperty("whether operation was successful or not")
    private boolean status;

    @ApiModelProperty("provides more insight in case an error occurs in api")
    private String description;

    @ApiModelProperty("actual response of api operation")
    private T data;

    private ResponseWrapper(boolean status, String description, T data) {
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

    public static <Type> ResponseWrapper<Type> success(Type data) {
        return new ResponseWrapper<>(true, null, data);
    }

    public static <Type> ResponseWrapper<Type> error(Exception err) {
        return new ResponseWrapper<>(false, err.getMessage(), null);
    }
}
