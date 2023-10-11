package com.OneSoft.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class OneSoftConfiguration extends WebSecurityConfigurerAdapter {
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("ss").password("$2a$10$C4ap3v7so8hBbAZgZM6FI.MQdNs2BDMFfRemnybwhJwerJYYeWyO6").roles("student");
//	}
//	@Bean
//	public PasswordEncoder getPassword() {
//		return new BCryptPasswordEncoder(10);
//	}
////	@Bean
////	public PasswordEncoder getPass() {
////		return  NoOpPasswordEncoder.getInstance();
////	}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("ss").password("$2a$10$PnqPGwRCic.Ft0Ar4VtUBO4r0nVN7/iUEidMytPUkN0CSjugUp6Je").roles("student").and().withUser("nk").password("$2a$10$VG2XTHa8xf0TsScNSNvuVO0QvJ91vqcR.ydw1P7PiN6.V0RtNp/j2").roles("trainer").and().withUser("sk").password("$2a$10$EkGpNCYLYYk9aF0iSyOT7.0nh1zR5.aSrYbbjuWJEBKJLc20vJRcG").roles("manager");
	}
	@Bean
	public PasswordEncoder getPassword() {
		return new BCryptPasswordEncoder(10);
	}
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/manager").hasRole("manager");
			http.authorizeRequests().antMatchers("/trainer").hasAnyRole("trainer","manager");
			http.authorizeRequests().antMatchers("/stuent").permitAll().and().formLogin();
			
		}

}
