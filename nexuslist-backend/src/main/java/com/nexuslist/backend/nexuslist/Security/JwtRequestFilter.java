package com.nexuslist.backend.nexuslist.Security;

/**
 * Responsibilies
 * * Check the Authorization header for a JWT
 * * If a token is found, user JwtUtil to validate it and extract a username
 * * If the token is valid, use UserDetailService to load the user's data
 * * Set the authenticated user in Spring Security's context (
 *   SecurityContextHolder). This is what tells the rest of Spring that the 
 *   user is logged in for this request
 * * If the token is invalid or not present, it does nothing and lets the 
 *   request continue, where Spring Security will later block it if the endpoint
 *   is protected
 */

public class JwtRequestFilter {

}
