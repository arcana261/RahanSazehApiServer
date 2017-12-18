package com.rahansazeh.apiserver.controller;

//import com.rahansazeh.apiserver.controller.error.NotFoundException;
//import com.rahansazeh.apiserver.model.BooleanResponse;
//import com.rahansazeh.apiserver.model.IdentifierResponse;
//import com.rahansazeh.apiserver.model.User;
//import com.rahansazeh.apiserver.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserRepository repository;
//
//    @GetMapping
//    public ResponseWrapper<List<User>> listUsers() {
//        return ResponseWrapper.success(repository.findAll());
//    }
//
//    @DeleteMapping
//    public ResponseWrapper<BooleanResponse> deleteAllUsers() {
//        repository.deleteAll();
//        return ResponseWrapper.success(new BooleanResponse(true));
//    }
//
//    @PostMapping
//    public ResponseWrapper<IdentifierResponse> createUser(@Valid @RequestBody User request) {
//        User user = repository.save(new User(request.getNationalCode()));
//        return ResponseWrapper.success(new IdentifierResponse(user.getId()));
//    }
//
//    @GetMapping("/{userName}")
//    public ResponseWrapper<User> getUser(@PathVariable String userName) throws Exception {
//        User user = repository.findByNationalCode(userName);
//        if (user == null) {
//            throw new NotFoundException("failed to locate user");
//        }
//        return ResponseWrapper.success(user);
//    }
//
//    @DeleteMapping("/{userName}")
//    public ResponseWrapper<BooleanResponse> removeUser(@PathVariable String userName) throws Exception {
//        User user = repository.findByNationalCode(userName);
//        if (user == null) {
//            throw new NotFoundException("failed to locate user");
//        }
//        repository.delete(user);
//        return ResponseWrapper.success(new BooleanResponse(true));
//    }
//}
