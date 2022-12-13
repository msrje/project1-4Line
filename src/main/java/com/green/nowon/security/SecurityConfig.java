package com.green.nowon.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {
	
	
	//DB의 인증정보를 이용해서 인증처리하는 service
	@Bean
	MyUserDetailsService myUserDetailsService() {
		return new MyUserDetailsService();
	}
	
	
	@Bean
    PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }
	
	@Bean
 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http
 			.authorizeRequests(authorize -> authorize
 						.antMatchers("/css/**","/images/**").permitAll()
 						.antMatchers("/","/members/signup","/members/join").permitAll()
 						.antMatchers("/admin/**").hasAnyRole("ROLE_ADMIN")
 						.anyRequest().authenticated()
 					)
 					.formLogin(formLogin->formLogin
 							.loginPage("/members/signin")//로그인 페이지
 							.loginProcessingUrl("/members/signin")//form안의 action 경로
 							.usernameParameter("email")
 							.passwordParameter("pass")
 							.defaultSuccessUrl("/")//성공시 이동 url
 							.failureUrl("/members/signin")//실패시 이동 url
 							.permitAll()
 							)
 					.logout(logout->logout
 							.logoutSuccessUrl("/members/signin"))
 					.csrf(csrf->csrf.disable())
 					
 					;
 		return http.build();
 	}

}
