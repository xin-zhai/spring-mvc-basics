package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dao.dto.RegisterUserRequest;
import com.thoughtworks.capacity.gtb.mvc.dao.User;
import com.thoughtworks.capacity.gtb.mvc.dao.dto.UserLoginRequest;
import com.thoughtworks.capacity.gtb.mvc.dao.dto.UserLoginResponse;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import com.thoughtworks.capacity.gtb.mvc.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> userLogin(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        UserLoginResponse userLoginResponse = userService.userLogin(userLoginRequest.getUsername(), userLoginRequest.getPassword());
        if(userLoginResponse == null) {
            throw new UserNotFoundException("用户名或密码错误");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userLoginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterUserRequest> register(@Valid @RequestBody RegisterUserRequest registerUserRequest) {
        User validUser = registerUserRequest.createUser();
        userService.registerUser(validUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
