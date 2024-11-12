package com.example.learn.spring.boot.openfeign.hello.remote;

import com.example.learn.spring.boot.openfeign.hello.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 相同name的情况下,通过不同的contextId来区分不同的bean,否则spring会报错
 */
@FeignClient(name = "mock-service", contextId = "MockUserServiceRemote3", url = "${mock-service.url}")
public interface MockUserServiceRemote3 {

    @GetMapping(value = "/user/getAllUsers", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    List<UserDto> getAllUsers();

    @GetMapping(value = "/user/getUser/{id}", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    UserDto getUser(@PathVariable("id") String userId);
}
