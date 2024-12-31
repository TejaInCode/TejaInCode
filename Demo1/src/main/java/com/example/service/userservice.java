package com.example.service;

import com.example.entity.userdtls;

public interface userservice {

    // Change the method name from 'create' to 'createUser'
    public userdtls createUser(userdtls user);
    public boolean checkEmail(String email);
}
