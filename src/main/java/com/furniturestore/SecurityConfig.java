package com.furniturestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.furniturestore.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("com.furniturestore")
public class SecurityConfig
{
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)
	        throws Exception
	{
	    http
	    	.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(authorize -> authorize
	            .requestMatchers(
	                    "/login",
	                    "/login/doLogin",
	                    "/registration",
	                    "/registration/doRegistration",
	                    "/css/**",
	                    "/js/**",
	                    "/images/**")
	            .permitAll()
	            .requestMatchers("/api/**").permitAll()
	            // All other pages require authentication
	            .anyRequest()
	            .authenticated()
	        )
	        .userDetailsService(userDetailsService)
	        .formLogin(form -> form
	            .loginPage("/login")
	            .loginProcessingUrl("/login/doLogin")
	            .usernameParameter("email")
	            .passwordParameter("password")
	            .defaultSuccessUrl("/", true)
	            .failureUrl("/login?error")
	            .permitAll()
	        )
	        //for REST API 
	        .httpBasic(httpBasic -> {})
	        
	        .logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/login?logout")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID")
	                .permitAll()
	        );

	    return http.build();
	}

	
}
