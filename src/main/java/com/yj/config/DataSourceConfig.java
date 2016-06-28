package com.yj.config;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
public class DataSourceConfig {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource getDefaultDataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setInitialSize(Integer.parseInt(env.getProperty("jdbc.initialSize")));
		dataSource.setMaxActive(Integer.parseInt(env.getProperty("jdbc.maxActive")));
		dataSource.setValidationQuery(env.getProperty("jdbc.validationQuery"));

		dataSource.setMaxIdle(Integer.parseInt(env.getProperty("jdbc.maxIdle")));
		dataSource.setMinIdle(Integer.parseInt(env.getProperty("jdbc.minIdle")));
		dataSource.setMaxWait(Integer.parseInt(env.getProperty("jdbc.maxWait")));
		dataSource.setTestOnBorrow(Boolean.parseBoolean(env.getProperty("jdbc.testOnBorrow")));
		dataSource.setTestOnReturn(Boolean.parseBoolean(env.getProperty("jdbc.testOnReturn")));
		dataSource.setTestWhileIdle(Boolean.parseBoolean(env.getProperty("jdbc.testWhileIdle")));
		dataSource.setTimeBetweenEvictionRunsMillis(
				Integer.parseInt(env.getProperty("jdbc.timeBetweenEvictionRunsMillis")));
		dataSource.setNumTestsPerEvictionRun(Integer.parseInt(env.getProperty("jdbc.numTestsPerEvictionRun")));
		dataSource.setMinEvictableIdleTimeMillis(Integer.parseInt(env.getProperty("jdbc.minEvictableIdleTimeMillis")));
		dataSource.setRemoveAbandonedTimeout(Integer.parseInt(env.getProperty("jdbc.removeAbandonedTimeout")));
		dataSource.setRemoveAbandoned(Boolean.parseBoolean(env.getProperty("jdbc.removeAbandoned")));
		dataSource.setLogAbandoned(Boolean.parseBoolean(env.getProperty("jdbc.logAbandoned")));

		return dataSource;
	}

	private Properties getDefaultProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format", env.getProperty("hibernate.format"));

		return properties;
	}

	@Bean
	public LocalSessionFactoryBean SessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDefaultDataSource());
		lsfb.setPackagesToScan("com.yj.model");
		lsfb.setHibernateProperties(getDefaultProperties());
		lsfb.setNamingStrategy(ImprovedNamingStrategy.INSTANCE);
		return lsfb;
	}

	@Bean
	public HibernateTransactionManager TransactionManager() {
		HibernateTransactionManager htm = new HibernateTransactionManager();
		htm.setSessionFactory(SessionFactory().getObject());
		htm.setNestedTransactionAllowed(true);
		return htm;
	}
}
