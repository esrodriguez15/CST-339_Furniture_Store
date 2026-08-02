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
/**
 * Security configuration for DEA Furniture Store application
 * 
 * This class defines all authentication rules with Spring Security and SPring Boot. 
 * Form-based login, Basic HTTP Authentication for REST API endpoitns, 
 * and bCryptEncoding for password encryption
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.furniturestore")
public class SecurityConfig
{
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	/**
	 * Provides BCrypt password encoder to encrypt passwords
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Authentication manager used by Spring Security
	 * @param config
	 * @return
	 * @throws Exception
	 */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
    /**
     * Security filter chain for handling Http security
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception
    {
        http

            // Ignore CSRF only for REST APIs
        	/**
        	 * Disables CSRF for REST API access
        	 */
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/api/**")
            )
            /**
             * Public access to login, registration, and static resources
             */
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

                /**
                 * REST APIs REQUIRE authentication
                 */
                .requestMatchers("/api/**")
                .authenticated()

                /**
                 * Requires authentication for all other pages
                 */
                .anyRequest()
                .authenticated()
            )

            .userDetailsService(userDetailsService)

            /**
             * Website login
             */
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login/doLogin")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error")
                .permitAll()
            )

            /**
             * REST API login
             */
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
