package com.example.learn.spring.boot.openfeign.hello.controller;

import com.example.learn.spring.boot.openfeign.hello.service.UserService;
import com.example.learn.spring.boot.openfeign.hello.service.UserService2;
import org.example.learn.spring.boot.openfeign.commons.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user2")
public class UserController2 {

    @Autowired
    private UserService2 userService;

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();

        return userDtoList;
    }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable("userId") String userId) {
        UserDto userDto = userService.getUser(userId);

        return userDto;
    }
}
