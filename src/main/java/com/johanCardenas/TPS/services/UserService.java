package com.johanCardenas.TPS.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.johanCardenas.TPS.models.User;
import com.johanCardenas.TPS.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
     @Transactional
    public User createUser(User user) {        
        return userRepository.save(user);
    }
    public ArrayList<User> getAllUsers() {
        return (ArrayList<User>)userRepository.findAll();
    }
    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> 
                    new EntityNotFoundException("Usuario no encontrado")
                    );
    }
     @Transactional
    public boolean deleteUser(Integer userId) {
        try {
            userRepository.deleteById(userId);
            return true;
        }catch(Exception err){
            return false;
        }
    }    
}
