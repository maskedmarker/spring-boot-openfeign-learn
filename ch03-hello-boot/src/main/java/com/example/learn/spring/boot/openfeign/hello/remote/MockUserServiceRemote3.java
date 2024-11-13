package com.example.learn.spring.boot.openfeign.hello.remote;

import com.example.learn.spring.boot.openfeign.hello.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 相同name的情况下,通过不同的contextId来区分不同的bean,否则spring会报错
 *
 * 添加@FeignClient注解的类的方法上的
 * GetMapping#consumes()对应http请求的Accept头;GetMapping#produces()对应http请求的Content-Type头
 * PostMapping#consumes()对应http请求的Accept头;PostMapping#produces()对应http请求的Content-Type头
 *
 */
@FeignClient(name = "mock-service", contextId = "MockUserServiceRemote3", url = "${mock-service.url}")
public interface MockUserServiceRemote3 {

    @GetMapping(value = "/user/getAllUsers", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    List<UserDto> getAllUsers();

    @GetMapping(value = "/user/getUser/{id}", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    UserDto getUser(@PathVariable("id") String userId);

    @PostMapping(value = "/user/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_XML_VALUE)
    UserDto addUser(@RequestBody UserDto userDto);
}
