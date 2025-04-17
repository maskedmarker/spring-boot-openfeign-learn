# spring-boot-openfeign-learn




## 暂存

为每个feign-client注册一个FeignClientSpecification
org.springframework.cloud.openfeign.FeignClientsRegistrar#registerClientConfiguration
为每个feign-client注册一个FeignClientFactoryBean
org.springframework.cloud.openfeign.FeignClientsRegistrar#registerFeignClient

### contextId
org.springframework.cloud.openfeign.FeignClientsRegistrar#getClientName该方法决定spring容器中FeignClientSpecification的名字


SynchronousMethodHandler
RequestTemplate

feign.SynchronousMethodHandler#invoke

### http日志
feign.Logger由底层的logger框架完成打印日志的功能.
logger的logger-name就是被@FeignClient注解的类的全名
logger日志级别由logger-name对应的logger框架的日志级别配置决定
只有debug级别的logger才能打印http请求响应日志.

### feign框架的启动入口
spring-cloud-openfeign-core中的spring.factories准备必须的基础对象
EnableFeignClients的FeignClientsRegistrar向spring容器中注册feign-client对象

## 疑问

FeignClientsConfiguration为什么会被扫描到???

org.springframework.cloud.openfeign.FeignAutoConfiguration.feignContext
```
@Bean
public FeignContext feignContext() {
    FeignContext context = new FeignContext();
    context.setConfigurations(this.configurations);
    return context;
}
```


org.springframework.context.annotation.ConfigurationClassPostProcessor.processConfigBeanDefinitions
