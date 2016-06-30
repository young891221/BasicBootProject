package com.yj;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;


@EnableAutoConfiguration
@EnableTransactionManagement
@Configuration
@ComponentScan
public class Application extends SpringBootServletInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);

		servletContext.addFilter("characterEncodingFilter",
				characterEncodingFilter).addMappingForUrlPatterns(
				EnumSet.of(DispatcherType.REQUEST), false, "/*");
		super.onStartup(servletContext);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		//factory.setUriEncoding();
		return factory;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver(ResourceUrlProvider urlProvider) {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		Map<String, Object> map = new HashMap<>();
		//map.put("helper", resourceHelper());
		resolver.setAttributesMap(map);
		resolver.setContentType("text/html;charset=utf-8");
		resolver.setPrefix("");
		resolver.setSuffix(".ftl");
		resolver.setRequestContextAttribute("rc");

		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
		
}
