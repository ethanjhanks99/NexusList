package com.nexuslist.backend.nexuslist.Security;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
