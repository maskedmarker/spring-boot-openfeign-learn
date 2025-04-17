

feign是一个什么式的http client.
http body的数据应该严格按照MIME类型的格式来传送.


## feign框架的启动入口
spring-cloud-openfeign-core中的spring.factories准备必须的基础对象
EnableFeignClients的FeignClientsRegistrar向spring容器中注册feign-client对象

```java
@Import(FeignClientsRegistrar.class)
public @interface EnableFeignClients {
   //...
}
```