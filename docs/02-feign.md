# spring-boot与feign


## feign启动


EnableFeignClients的FeignClientsRegistrar向spring容器中注册feign-client对象

spring-cloud-openfeign-core中的spring.factories准备必须的基础对象
```text
只罗列最基础的
org.springframework.cloud.openfeign.FeignAutoConfiguration
```

### FeignAutoConfiguration

FeignAutoConfiguration类不仅被写入了写入了spring-cloud-openfeign-core的spring.factories中,而且自身还被@Configuration注释(这是为了兼容历史版本???)
FeignAutoConfiguration类仅仅提供了基础bean,并没有所需的完整配置(比如需要FeignClientsRegistrar来额外添加beanDefinition)

```text
// 最基础的配置,非基础的代码都已省略
@Configuration
public class FeignAutoConfiguration {

    // 需要通过FeignClientsRegistrar向spring容器注册的
	@Autowired(required = false)
	private List<FeignClientSpecification> configurations = new ArrayList<>();

   // FeignContext是一个重要的类
	@Bean
	public FeignContext feignContext() {
		FeignContext context = new FeignContext();
		context.setConfigurations(this.configurations);
		return context;
	}

	@Configuration(proxyBeanMethods = false)
	@ConditionalOnClass(name = "feign.hystrix.HystrixFeign")
	protected static class HystrixFeignTargeterConfiguration {
		@Bean
		@ConditionalOnMissingBean
		public Targeter feignTargeter() { // Targeter ???
			return new HystrixTargeter(); 
		}
	}
}
```



### FeignClientsRegistrar

FeignClientsRegistrar是最关键的一个类.向容器中注册了所需的bean(待完成)!!!!

```java
@Import(FeignClientsRegistrar.class)
public @interface EnableFeignClients {
   //...
}
```


### FeignContext

FeignContext需要讲的内容也很多.!!!

```text
public class FeignContext extends NamedContextFactory<FeignClientSpecification> {

	public FeignContext() {
	    // 注意这里的FeignClientsConfiguration
		super(FeignClientsConfiguration.class, "feign", "feign.client.name");
	}

	@Nullable
	public <T> T getInstanceWithoutAncestors(String name, Class<T> type) {
		try {
			return BeanFactoryUtils.beanOfType(getContext(name), type);
		}
		catch (BeansException ex) {
			return null;
		}
	}

	@Nullable
	public <T> Map<String, T> getInstancesWithoutAncestors(String name, Class<T> type) {
		return getContext(name).getBeansOfType(type);
	}

}
```