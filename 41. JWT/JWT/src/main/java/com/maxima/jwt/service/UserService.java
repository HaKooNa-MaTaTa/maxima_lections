package com.maxima.jwt.service;

import com.maxima.jwt.model.UserEntity;

public interface UserService {

    UserEntity findByUsername(String username);
}
