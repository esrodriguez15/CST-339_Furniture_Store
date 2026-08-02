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
=======

/**
 * Configures authentication, page security, REST API security,
 * form login, HTTP Basic authentication, and logout behavior.
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.furniturestore")
public class SecurityConfig
{
	/**
	 * Loads user account information from the database for authentication.
	 */
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	/**
	 * Creates the password encoder used to encrypt and verify passwords.
	 *
	 * @return the BCrypt password encoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
<<<<<<< HEAD
	 * Authentication manager used by Spring Security
	 * @param config
	 * @return
	 * @throws Exception
=======
	 * Creates the authentication manager used by Spring Security.
	 *
	 * @param config the Spring authentication configuration
	 * @return the configured authentication manager
	 * @throws Exception if the authentication manager cannot be created
>>>>>>> ebd241d669a4580cb724fa01bee8106c1f180e00
	 */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
    /**
     * Defines access rules for web pages and REST APIs and configures
     * form login, HTTP Basic authentication, and logout.
     *
     * @param http the HTTP security configuration
     * @return the configured security filter chain
     * @throws Exception if the security configuration cannot be created
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
