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

    // Bonus: Seed some test data on startup (optional, but helpful for testing)
    // You can call this in a @PostConstruct in the main app class if needed
    public void createSampleUsers() {
        if (userRepository.count() == 0) {
            userRepository.save(new User("Simaha Shariff", "simaha@example.com"));
            userRepository.save(new User("Jane Smith", "jane@example.com"));
        }
    }
}