package com.nexuslist.backend.nexuslist.Security;

import org.springframework.web.bind.annotation.RestController;

/**
 * Responsibilies
 * * Expose a public POST /login (or /authenticate) endpoint
 * * Accept a username and password in the request body
 * * Use Spring Security's AuthenticationManger to validate the credentials
 * * If authentication is successful, use JwtUtil to generate a token
 * * Return the generated token to the client in the response body
 */

@RestController
public class AuthController {

}
