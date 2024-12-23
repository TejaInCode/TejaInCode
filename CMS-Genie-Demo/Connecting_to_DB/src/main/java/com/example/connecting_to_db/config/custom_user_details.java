package com.example.connecting_to_db.config;

import com.example.connecting_to_db.entity.Userdetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class custom_user_details implements UserDetails {

//    created object for the class Userdetails in entity package.
    private Userdetails u;

    public custom_user_details(Userdetails u) {
        this.u = u;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<SimpleGrantedAuthority> set = new HashSet<SimpleGrantedAuthority>();
        set.add(new SimpleGrantedAuthority(u.getRole()));
        return set;
    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public String getUsername() {
        return u.getEmail();
    }
}
//  Why Do We Use UserDetails?
//      Spring Security needs a standard way to handle user information during authentication. The UserDetails interface provides this standard by defining methods that return:
//             Username and Password of the user.
//             User's authorities/roles (permissions).
//      Whether the account is active or locked, expired, etc.
//          By implementing this interface, you can integrate your user data (from a database or elsewhere) into Spring Security.

//Learn abut HashSet------->HashSet<SimpleGrantedAuthority> set = new HashSet<SimpleGrantedAuthority>();
//        set.add(new SimpleGrantedAuthority(u.getRole()));

