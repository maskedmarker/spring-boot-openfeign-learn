

```java
class FeignClientFactoryBean {
    protected void configureFeign(FeignContext context, Feign.Builder builder) {
        // FeignClientProperties是全局的包含所有client的配置信息(包括default配置信息和用户指定client的配置信息)
        FeignClientProperties properties = applicationContext.getBean(FeignClientProperties.class);

        FeignClientConfigurer feignClientConfigurer = getOptional(context, FeignClientConfigurer.class);
        setInheritParentContext(feignClientConfigurer.inheritParentConfiguration());

        if (properties != null && inheritParentContext) {
            // 通过编程方式设置的配置信息被称为UsingConfiguration
            // 通过配置文件方式设置的配置信息被称为UsingProperties
            if (properties.isDefaultToProperties()) {
                // 通过编程方式设置的配置信息
                configureUsingConfiguration(context, builder);
                // default配置信息作为兜底,优先级比较低.所以先执行
                configureUsingProperties(properties.getConfig().get(properties.getDefaultConfig()), builder);
                // properties文件中用户的配置信息优先级最高,所以最后执行
                configureUsingProperties(properties.getConfig().get(contextId), builder);
            }
            else {
                configureUsingProperties(properties.getConfig().get(properties.getDefaultConfig()), builder);
                configureUsingProperties(properties.getConfig().get(contextId), builder);
                configureUsingConfiguration(context, builder);
            }
        }
        else {
            configureUsingConfiguration(context, builder);
        }
    }
}
```