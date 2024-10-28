package com.maxima.springbootintro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Enumerated(value = EnumType.ORDINAL)
    private State state;

    @Enumerated(value = EnumType.ORDINAL)
    private Role role;

    public enum Role {
        USER, ADMIN
    }

    public enum State {
        CONFIRMED, NOT_CONFIRMED, BANNED, DELETED
    }
}
