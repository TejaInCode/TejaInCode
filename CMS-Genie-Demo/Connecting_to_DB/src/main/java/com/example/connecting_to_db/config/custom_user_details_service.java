package com.example.connecting_to_db.config;

import com.example.connecting_to_db.entity.Userdetails;
import com.example.connecting_to_db.repository.userepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class custom_user_details_service implements UserDetailsService {

    @Autowired
    private userepository repo;


    @Override
    public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {

        try {
            Userdetails u =repo.findByEmail(em);

            if(u==null){
                throw new UsernameNotFoundException("User not found");
            }else{
                return new custom_user_details(u);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }
}
