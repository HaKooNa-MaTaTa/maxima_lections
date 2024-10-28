package oneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String patronymic;

    /*
    Виды отношений:
        OneToMany
        ManyToOne
        ManyToMany
    Слева от To (One[To]One) количество сущностей, в котором мы находимся
    Справа от To количество сущностей, которые указаны под этой аннотацией
     */
    //TODO ошибка?
    @OneToOne
    private Passport passport;
}
