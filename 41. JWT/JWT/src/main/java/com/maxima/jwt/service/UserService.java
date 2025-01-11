package com.maxima.jwt.service;

import com.maxima.jwt.model.UserEntity;

public interface UserService {

    boolean validateUser(String username, String password);
    UserEntity findByUsername(String username);
}
