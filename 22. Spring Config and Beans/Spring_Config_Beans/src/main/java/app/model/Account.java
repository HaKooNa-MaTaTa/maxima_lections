package app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс-модель, отображающий аккаунт пользователя в нашем сервисе
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
