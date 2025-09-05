package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home", "/upload/**").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/board/**").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login").permitAll()
				.successHandler(authenticationSuccessHandler())
			)
			
			// 밑에 주석처리한 방법ㅂ보다 위에 form 방식 사용.
//			.formLogin().loginPage("/login")
//			            .successHandler(authenticationSuccessHandler())
//			 .and()
			.logout((logout) -> logout.permitAll());
		
			http.csrf(csrf -> csrf.disable());
			http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));

		return http.build();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
//	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("USER")
				.build();
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1234")
					.roles("ADMIN")
					.build();


		return new InMemoryUserDetailsManager(user, admin);
	}
}