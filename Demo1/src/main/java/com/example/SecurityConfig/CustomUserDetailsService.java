package com.example.SecurityConfig;

import com.example.entity.userdtls;
import com.example.repository.userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private userepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Fetch user details from the repository using email
        userdtls user = userRepo.findByEmail(email);
        if (user != null) {
            // Pass the user to CustomUserDetails
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
