package com.fyp.bookexchange.service;

import com.fyp.bookexchange.entity.User;
import com.fyp.bookexchange.repository.UserRepository;
import com.fyp.bookexchange.security.CustomUserDetails;
import com.fyp.bookexchange.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
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
