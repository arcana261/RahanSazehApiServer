package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.LoginRequest;
import com.rahansazeh.apiserver.model.LoginResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Response<LoginResponse> login(@RequestBody LoginRequest request) {
        return Response.success(new LoginResponse("0010220887".equals(request.getUserName())));
    }
}
