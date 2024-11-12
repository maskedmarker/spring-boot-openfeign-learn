package com.example.learn.spring.boot.openfeign.hello.controller;

import com.example.learn.spring.boot.openfeign.hello.model.UserDto;
import com.example.learn.spring.boot.openfeign.hello.service.UserService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user3")
public class UserController3 {

    @Autowired
    private UserService3 userService;

    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();

        return userDtoList;
    }

    @GetMapping(value = "/getUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUser(userId);

        return userDto;
    }
}
