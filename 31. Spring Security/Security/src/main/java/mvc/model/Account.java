package mvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @Enumerated(value = EnumType.STRING)
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
