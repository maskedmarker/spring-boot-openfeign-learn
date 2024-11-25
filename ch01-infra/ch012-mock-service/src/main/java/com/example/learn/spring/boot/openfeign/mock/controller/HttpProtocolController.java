package com.example.learn.spring.boot.openfeign.mock.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/http")
public class HttpProtocolController {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @RequestMapping(path = "/info", produces = MediaType.TEXT_PLAIN_VALUE)
    public String info(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        Map<String, Object> parameterInfo = parameterInfo(request);

        return OBJECT_MAPPER.writeValueAsString(parameterInfo);
    }

    private Map<String, Object> parameterInfo(HttpServletRequest request) {
        Map<String, Object> info = new HashMap<>();

        // The returned URL contains a protocol, server name, port number, and server path, but it does not include query string parameters
        StringBuffer requestURL = request.getRequestURL();
        info.put("requestURL", requestURL.toString());

        // Returns the part of this request's URL from the protocol name up to the query string in the first line of the HTTP request.
        // The web container does not decode this String(如果包含中文,则返回的是percent-encoding字符串)
        String requestURI = request.getRequestURI();
        info.put("requestURI", requestURI);

        String contentType = request.getContentType();
        info.put("contentType", contentType);

        Map<String, String[]> requestParameterMap = request.getParameterMap();
        info.put("requestParameterMap", requestParameterMap);


        return info;
    }
}
