package com.nexuslist.backend.nexuslist.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nexuslist.backend.nexuslist.User.UserRepository;

/**
 * Responsibilities
 * * One method: loadUserByUsername(String username)
 * * connect to the database (via UserRepository) and fetch the full user 
 *   details for a given username. Spring security uses this during the 
 *   authentication process.
 */

@Service
public class NexusUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public NexusUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails)userRepository.findByUsername(username);
    }
    
}
