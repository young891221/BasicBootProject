package com.yj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(Ordered.LOWEST_PRECEDENCE - 8)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/css/**")
				.antMatchers("/images/**")
				.antMatchers("/js/**")
				.antMatchers("/partial/**")
				.antMatchers("/vendor/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login")
					.permitAll()
				.antMatchers("/logout")
					.permitAll()
				.antMatchers("/accessDenied")
					.permitAll()
				.antMatchers("/authentication")
					.permitAll()
				.antMatchers("/error")
					.permitAll()
				/*.antMatchers("/**")
					.access("hasRole('ROLE')")*/
			.and()
				.formLogin()
				.loginPage("/login")
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
			.and()
				.exceptionHandling()
				.accessDeniedPage("/accessDenied")
			.and()
				.csrf()
					.disable();
	}
}