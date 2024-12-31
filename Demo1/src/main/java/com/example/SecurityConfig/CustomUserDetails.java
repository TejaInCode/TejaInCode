package com.example.SecurityConfig;

import com.example.entity.userdtls;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private userdtls user;  // This is just a member variable, no need for @Autowired

    // Constructor to initialize the user
    public CustomUserDetails(userdtls user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Map the role to a SimpleGrantedAuthority
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;  // Modify according to your business logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Modify according to your business logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Modify according to your business logic
    }

    @Override
    public boolean isEnabled() {
        return true;  // Modify according to your business logic
    }
}
