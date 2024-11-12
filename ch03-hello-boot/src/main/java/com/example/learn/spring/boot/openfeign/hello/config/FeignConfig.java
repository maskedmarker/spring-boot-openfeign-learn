package com.example.learn.spring.boot.openfeign.hello.config;

import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

/*    @Bean
    public Decoder feignDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new XmlDecoder(); // 自定义XML解码器
    }

    @Bean
    public Encoder feignEncoder() {
        return new XmlEncoder(); // 自定义XML编码器
    }*/
}
