package com.nexuslist.backend.nexuslist.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Responsibilities
 * * One method: loadUserByUsername(String username)
 * * connect to the database (via UserRepository) and fetch the full user 
 *   details for a given username. Spring security uses this during the 
 *   authentication process.
 */

@Service
public class NexusUserDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    
}
