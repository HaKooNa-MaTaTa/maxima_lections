package project.dto;

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
    private String patronymic;
    private int age;
    private String email;
}
