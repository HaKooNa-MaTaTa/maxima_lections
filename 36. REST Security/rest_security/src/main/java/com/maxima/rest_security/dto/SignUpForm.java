package com.maxima.rest_security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
