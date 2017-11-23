package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.model.LoginRequest;
import com.rahansazeh.apiserver.model.LoginResponse;
import com.rahansazeh.apiserver.model.User;
import com.rahansazeh.apiserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Response<LoginResponse> login(@RequestBody LoginRequest request) {
        User user = repository.findByNationalCode(request.getUserName());

        return Response.success(new LoginResponse(user != null));
    }
}
