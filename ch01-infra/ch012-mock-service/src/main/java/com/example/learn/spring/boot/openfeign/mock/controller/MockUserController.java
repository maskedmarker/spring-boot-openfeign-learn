package com.example.learn.spring.boot.openfeign.mock.controller;

import org.example.learn.spring.boot.openfeign.commons.model.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class MockUserController {

    private List<UserDto> allUsers = new ArrayList<>();

    @PostConstruct
    private void setup() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            UserDto userDto = new UserDto();
            userDto.setUserId(Integer.toString(i));
            userDto.setName("name" + i);
            userDtoList.add(userDto);
        }

        allUsers.addAll(userDtoList);
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers() {
        return allUsers;
    }

    @GetMapping("/getUser/{userId}")
    public UserDto getUser(@PathVariable("userId") String userId) {
        Optional<UserDto> first = allUsers.stream()
                .filter(userDto -> userDto.getUserId().equals(userId))
                .findFirst();

        return first.orElse(null);
    }

    @PostMapping("/addUser")
    public UserDto addUser(@RequestBody UserDto userDto) {
        allUsers.add(userDto);
        return userDto;
    }
}
