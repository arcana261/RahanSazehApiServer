package com.rahansazeh.apiserver.apis.responses;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class BooleanResponse {
    @ApiModelProperty("result of operation")
    private boolean result;

    public BooleanResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}
