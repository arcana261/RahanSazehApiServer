package com.rahansazeh.apiserver.controller;

import com.rahansazeh.apiserver.controller.error.NotFoundException;
import com.rahansazeh.apiserver.model.BooleanResponse;
import com.rahansazeh.apiserver.model.IdentifierResponse;
import com.rahansazeh.apiserver.model.User;
import com.rahansazeh.apiserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public Response<List<User>> listUsers() {
        return Response.success(repository.findAll());
    }

    @DeleteMapping("/user")
    public Response<BooleanResponse> deleteAllUsers() {
        repository.deleteAll();
        return Response.success(new BooleanResponse(true));
    }

    @PostMapping("/user")
    public Response<IdentifierResponse> createUser(@Valid @RequestBody User request) {
        User user = repository.save(new User(request.getNationalCode()));
        return Response.success(new IdentifierResponse(user.getId()));
    }

    @GetMapping("/user/{userName}")
    public Response<User> getUser(@PathVariable String userName) throws Exception {
        User user = repository.findByNationalCode(userName);
        if (user == null) {
            throw new NotFoundException("failed to locate user");
        }
        return Response.success(user);
    }

    @DeleteMapping("/user/{userName}")
    public Response<BooleanResponse> removeUser(@PathVariable String userName) throws Exception {
        User user = repository.findByNationalCode(userName);
        if (user == null) {
            throw new NotFoundException("failed to locate user");
        }
        repository.delete(user);
        return Response.success(new BooleanResponse(true));
    }
}
