package com.maxima.jwt.service;

import com.maxima.jwt.model.UserEntity;
import com.maxima.jwt.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl target;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //1. Юзера нет
    @Test
    void validateUserFalse_userNotFound() {
        when(userRepository.findByUsername("userNotFound")).thenReturn(null);

        boolean isValid = target.validateUser("userNotFound", null);
        assertFalse(isValid);
    }

    //2. Юзер есть, но не правильный пароль
    @Test
    void validateUserFalse_invalidPassword() {
        UserEntity userEntity = new UserEntity(
            null,
            "user",
            "password",
            null
        );
        when(userRepository.findByUsername("user")).thenReturn(userEntity);

        boolean isValid = target.validateUser("user", "InvalidPassword");
        assertFalse(isValid);
    }
    //3. Юзер есть и правильный пароль
    @Test
    void validateUserTrue() {
        UserEntity userEntity = new UserEntity(
            null,
            "user",
            "password",
            null
        );
        when(userRepository.findByUsername("user")).thenReturn(userEntity);

        boolean isValid = target.validateUser("user", "password");
        assertTrue(isValid);
    }
}