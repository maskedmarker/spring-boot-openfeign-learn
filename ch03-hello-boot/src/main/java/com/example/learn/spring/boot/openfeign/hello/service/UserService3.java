package com.example.learn.spring.boot.openfeign.hello.service;

import com.example.learn.spring.boot.openfeign.hello.model.UserDto;
import com.example.learn.spring.boot.openfeign.hello.remote.MockUserServiceRemote3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService3 {

    @Autowired
    private MockUserServiceRemote3 mockUserServiceRemote;

    public List<UserDto> getAllUsers() {
        List<UserDto> allUsers = mockUserServiceRemote.getAllUsers();
        return allUsers;
    }

    public UserDto getUser(String userId) {
        UserDto user = mockUserServiceRemote.getUser(userId);
        return user;
    }
}
