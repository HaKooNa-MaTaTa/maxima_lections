package mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mvc.model.Account;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Account.Role role;
    private Account.State state;
}
