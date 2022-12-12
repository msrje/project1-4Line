package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
	
	@Bean
 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http
 			.authorizeRequests(authorize -> authorize
 						.antMatchers("/css/**","/images/**").permitAll()
 						.antMatchers("/","member/signup").permitAll()
 						.antMatchers("/admin/**").hasAnyRole("ADMIN")
 						.anyRequest().authenticated()
 					)
 					.formLogin(formLogin->formLogin
 							.loginPage("/member/login")
 							.loginProcessingUrl("/member/login")
 							.usernameParameter("email")
 							.passwordParameter("pass")
 							.permitAll()
 							).csrf(csrf->csrf.disable())
 					;
 		return http.build();
 	}

}
