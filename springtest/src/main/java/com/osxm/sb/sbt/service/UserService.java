package com.osxm.sb.sbt.service;


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
