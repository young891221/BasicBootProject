package com.yj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
  * @Project : BasicBootProject
  * @Date : 2016. 6. 28. 
  * @author : Kim YJ
  * @변경이력 :
  */
@Configuration
public class EnvironmentConfig {
    @Configuration
    @PropertySource(
            ignoreResourceNotFound = true,
            value = {
                    "classpath:/properties/datasource.properties",
                    "classpath:/properties/version.properties"
            }
    )
    public static class ProductionProperties {
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
            return new PropertySourcesPlaceholderConfigurer();
        }
    }
}
