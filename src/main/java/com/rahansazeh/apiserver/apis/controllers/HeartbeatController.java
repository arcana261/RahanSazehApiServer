package com.rahansazeh.apiserver.apis.controllers;

import com.rahansazeh.apiserver.apis.controllers.wrappers.ResponseWrapper;
import com.rahansazeh.apiserver.apis.responses.BooleanResponse;
import com.rahansazeh.apiserver.services.HeartbeatService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/heartbeat")
@RestController
@Api("heartbeat")
public class HeartbeatController {
    @Autowired
    private HeartbeatService heartbeatService;

    @GetMapping("/")
    @ApiOperation("checks status of server")
    @ApiResponses({
            @ApiResponse(code = 200, message = "status of server")
    })
    public ResponseWrapper<BooleanResponse> checkHeartbeat() {
        return ResponseWrapper.success(new BooleanResponse(heartbeatService.checkHeartbeat()));
    }
}
