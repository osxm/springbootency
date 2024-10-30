package com.osxm.sb.sbt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.osxm.sb.sbt.model.User;
import com.osxm.sb.sbt.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;  
  
    @Autowired  
    public UserService(UserRepository userRepository) {  
        this.userRepository = userRepository;  
    }  
  
    public User findUserById(Long id) {  
        return userRepository.findById(id).orElse(null);  
    } 
}
