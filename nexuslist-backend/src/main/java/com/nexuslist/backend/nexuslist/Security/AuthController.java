package com.nexuslist.backend.nexuslist.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        final String jwt = jwtUtil.generateToken(authRequest.getUsername());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
