package com.example.connecting_to_db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MyConfig {

    @Bean
    public UserDetailsService getuserDetailsService() {
        return new custom_user_details_service();  // Ensure custom_user_details_service implements UserDetailsService
    }

    @Bean
    public BCryptPasswordEncoder getPassword() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(getuserDetailsService());
        provider.setPasswordEncoder(getPassword());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasRole("USER")  // Role-based access control
                        .anyRequest().permitAll()  // Allow other requests
                )
                .formLogin(form -> form  // Updated formLogin approach
                        .loginPage("/login")  // Optionally specify your login page
                        .permitAll()  // Allow everyone to access the login page
                )
                .csrf(csrf -> csrf.disable());  // Explicitly disable CSRF

        return http.build();
    }
}
