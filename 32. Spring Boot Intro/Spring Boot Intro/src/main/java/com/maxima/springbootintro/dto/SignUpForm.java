package com.maxima.springbootintro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.maxima.springbootintro.model.Account;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
