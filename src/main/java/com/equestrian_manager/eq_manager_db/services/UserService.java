package com.equestrian_manager.eq_manager_db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.equestrian_manager.eq_manager_db.dtos.UserDto;
import com.equestrian_manager.eq_manager_db.mappers.UserMapper;
import com.equestrian_manager.eq_manager_db.models.User;
import com.equestrian_manager.eq_manager_db.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDto getUserDetails(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("No user found with ID: " + userId));

        return userMapper.convertToDto(user);
    }
}
