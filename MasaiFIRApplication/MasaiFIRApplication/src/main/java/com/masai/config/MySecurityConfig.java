package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				(auth) -> auth.antMatchers("/fir").hasAuthority("fir")
				.antMatchers("/user").permitAll()
		).httpBasic();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encodePassword() {
		//return NoOpPasswordEncoder.getInstance(); //Not recommended
		return new BCryptPasswordEncoder();
	}
}
