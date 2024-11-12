package com.example.learn.spring.boot.openfeign.hello.remote;

import org.example.learn.spring.boot.openfeign.commons.model.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 相同name的情况下,通过不同的contextId来区分不同的bean,否则spring会报错
 */
@FeignClient(name = "mock-service", contextId = "MockUserServiceRemote2", url = "${mock-service.url}")
public interface MockUserServiceRemote2 {

    @GetMapping("/user/getAllUsers")
    List<UserDto> getAllUsers();

    @GetMapping("/user/getUser/{id}")
    UserDto getUser(@PathVariable("id") String userId);
}
