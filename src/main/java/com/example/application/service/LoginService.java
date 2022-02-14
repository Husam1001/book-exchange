package com.example.application.service;

import com.example.application.security.CustomUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    CustomUserDetailsService customUserDetailsService;
    public void verifyUser(String email, String password){
        UserDetails user= customUserDetailsService.loadUserByUsername(email);
        if (user.getPassword().equals(password)){

        }
    }
}
