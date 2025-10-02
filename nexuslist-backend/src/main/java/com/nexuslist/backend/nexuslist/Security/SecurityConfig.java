package com.nexuslist.backend.nexuslist.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Responcibilies
 * * Disable older, stateful security features like CSRF and sessions
 * * Define your security rules: which endpoints are public (like /login)
 *   and which are protected and require authentication
 * * Register custom JwtRequestFilter into the main Spring Security filter 
 *   chain, ensureing it runs at the correct time
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

}
