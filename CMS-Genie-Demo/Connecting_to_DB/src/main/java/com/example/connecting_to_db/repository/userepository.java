package com.example.connecting_to_db.repository;

import com.example.connecting_to_db.entity.Userdetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userepository extends JpaRepository<Userdetails,Integer> {

    public Userdetails findByEmail(String em);

}
