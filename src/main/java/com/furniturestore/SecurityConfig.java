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
 * Configures authentication, page security, REST API security,
 * form login, HTTP Basic authentication, and logout behavior.
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
	 * Creates the authentication manager used by Spring Security.
	 *
	 * @param config the Spring authentication configuration
	 * @return the configured authentication manager
	 * @throws Exception if the authentication manager cannot be created
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
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/api/**")
            )

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

                // REST APIs REQUIRE authentication
                .requestMatchers("/api/**")
                .authenticated()

                // Everything else also requires login
                .anyRequest()
                .authenticated()
            )

            .userDetailsService(userDetailsService)

            // Website login
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login/doLogin")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login?error")
                .permitAll()
            )

            // REST API login
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
