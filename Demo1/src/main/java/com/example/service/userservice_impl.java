package com.example.service;

import com.example.entity.userdtls;
import com.example.repository.userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userservice_impl implements userservice {

    @Autowired
    private userepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncode;  // Use the generic PasswordEncoder instead of directly using BCryptPasswordEncoder.


    @Override
    public userdtls createUser(userdtls user) {
        user.setPassword(passwordEncode.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
