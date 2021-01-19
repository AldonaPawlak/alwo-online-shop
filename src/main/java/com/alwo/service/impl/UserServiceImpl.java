package com.alwo.service.impl;

import com.alwo.model.User;
import com.alwo.repository.UserRepository;
import com.alwo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getOne(userId);
    }
}
