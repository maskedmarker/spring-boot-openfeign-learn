package com.example.learn.spring.boot.openfeign.hello.service;

import com.example.learn.spring.boot.openfeign.hello.remote.MockUserServiceRemote;
import com.example.learn.spring.boot.openfeign.hello.remote.MockUserServiceRemote2;
import org.example.learn.spring.boot.openfeign.commons.model.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService2 {

    @Autowired
    private MockUserServiceRemote2 mockUserServiceRemote;

    public List<UserDto> getAllUsers() {
        List<UserDto> allUsers = mockUserServiceRemote.getAllUsers();
        return allUsers;
    }

    public UserDto getUser(String userId) {
        UserDto user = mockUserServiceRemote.getUser(userId);
        return user;
    }
}
