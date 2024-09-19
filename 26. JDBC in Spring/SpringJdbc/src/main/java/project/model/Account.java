package project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private UUID id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private String email;
}
