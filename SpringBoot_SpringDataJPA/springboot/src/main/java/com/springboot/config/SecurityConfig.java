package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Autowired
	private UserDetailsService  userDetailsService;

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
		    .authorizeRequests()
		    	.antMatchers("/template/**").permitAll()
		        .antMatchers("/dang-nhap").permitAll()
				.antMatchers("/quan-tri/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			    .and()
			.formLogin()
			    .loginPage("/dang-nhap")
			    .loginProcessingUrl("/j_spring_security_check")
			    .usernameParameter("username")
				.passwordParameter("password")
				.successHandler(successHandler)
				.failureUrl("/dang-nhap?incorrectAccount")
			    .and()
			 .logout()
			    .logoutUrl("/dang-xuat")
			    .logoutSuccessUrl("/dang-nhap?logout")
			    .and()
	         .rememberMe().key("uniqueAndSecret").rememberMeParameter("remember-me")
	            .and()
			.exceptionHandling().accessDeniedPage("/accessDenied");
	}
	

}
