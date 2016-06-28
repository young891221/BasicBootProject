package com.yj.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;

/**
  * @Project : BasicBootProject
  * @Date : 2016. 6. 28. 
  * @author : Kim YJ
  * @변경이력 :
  */
@Configuration
@EnableSpringDataWebSupport
public class AppConfig {

	@Bean
	public RestOperations restOperations() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(10000);
		RestTemplate restTemplate = new RestTemplate(factory);
		StringHttpMessageConverter stringMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		MappingJackson2HttpMessageConverter jackson2Converter = new MappingJackson2HttpMessageConverter();
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(jackson2Converter);
		converters.add(stringMessageConverter);
		restTemplate.setMessageConverters(converters);
		return restTemplate;
	}
	
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper= new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		Hibernate4Module hibernate4Module=new Hibernate4Module();
		hibernate4Module.disable(Feature.USE_TRANSIENT_ANNOTATION);
		objectMapper.registerModule(hibernate4Module);
		return objectMapper;
	}	
	
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}
