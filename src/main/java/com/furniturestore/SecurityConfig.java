package com.furniturestore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
			throws Exception
	{
		http
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(
						"/login",
						"/login/doLogin",
						"/registration",
						"/css/**",
						"/js/**",
						"/images/**")
				.permitAll()

				/*
				 * Damian will change this to authenticated()
				 * when securing the remaining pages.
				 */
				.anyRequest()
				.permitAll()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.loginProcessingUrl("/login/doLogin")
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?error")
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			);

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}