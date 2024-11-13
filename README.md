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
feign.Logger