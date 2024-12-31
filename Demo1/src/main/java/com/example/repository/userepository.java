package com.example.repository;

import com.example.entity.userdtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userepository extends JpaRepository<userdtls, Integer> {

    boolean existsByEmail(String email);

    userdtls findByEmail(String email);
}
