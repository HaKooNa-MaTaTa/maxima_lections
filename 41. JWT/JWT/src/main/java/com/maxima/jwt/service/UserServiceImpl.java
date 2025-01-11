package com.maxima.jwt.service;

import com.maxima.jwt.model.UserEntity;
import com.maxima.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validateUser(String username, String password) {
        UserEntity userEntity = findByUsername(username);
        if (userEntity == null) {
            return false;
        }
        return userEntity.getPassword().equals(password);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
