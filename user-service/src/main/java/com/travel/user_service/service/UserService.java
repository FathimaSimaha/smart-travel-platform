package com.travel.user_service.service;

import com.travel.user_service.entity.User;
import com.travel.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void createSampleUsers() {
        if (userRepository.count() == 0) {
            userRepository.save(new User("Simaha Shariff", "sima@example.com"));
            userRepository.save(new User("Jane Smith", "jane@example.com"));
            
        }
    }
}