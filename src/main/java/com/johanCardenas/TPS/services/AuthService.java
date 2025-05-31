package com.johanCardenas.TPS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanCardenas.TPS.repositories.UserRepository;

@Service
public class AuthService {
 
    @Autowired
    private UserRepository userRepository;

    public void login(){
        
    }
}
