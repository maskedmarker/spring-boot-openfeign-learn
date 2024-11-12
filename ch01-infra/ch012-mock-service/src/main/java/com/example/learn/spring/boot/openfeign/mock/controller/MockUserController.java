package com.example.learn.spring.boot.openfeign.mock.controller;

import org.example.learn.spring.boot.openfeign.commons.model.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MockUserController {

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserDto userDto = new UserDto();
            userDto.setUserId(Integer.toString(i));
            userDto.setName("name" + i);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable("userId") String userId) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setName("name" + userId);

        return userDto;
    }
}
