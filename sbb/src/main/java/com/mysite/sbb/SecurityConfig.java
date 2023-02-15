package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration		//Security 의 설정을 적용하는 어노테이션
@EnableWebSecurity	// http의 URL 접근을 제어하는 어노테이션
public class SecurityConfig {
	
	// 모든 URL에서 접근할 수 있도록 풀어줌.
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests().requestMatchers(
				new AntPathRequestMatcher("/**")).permitAll()
		
	/*
	 * and() - http 객체의 설정을 이어서 할 수 있게 하는 메서드이다. •
	 * csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")) -
	 * /h2- console/로 시작하는 URL 은 CSRF 검증을 하지 않는다는 설정이다
	 */
	
	// h2 콘솔 접근 가능하도록 풀어줌.
			.and().csrf().ignoringRequestMatchers(
					new AntPathRequestMatcher("/h2-console/**"))
		
			.and().headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
					XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN));
		
				return http.build();
	}
	
	// password bean 객체
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
