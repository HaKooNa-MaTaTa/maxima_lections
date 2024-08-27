package reflection.framework;

import java.time.LocalDate;

//Заявка
public class Statement {

    private String name;
    private LocalDate birthDate;
    @DefaultValue("OOO 'Рога и Копыта'")
    private String companyName;
    @DefaultValue("1236541578")
    private String companyInn;

    public Statement(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Statement{" +
            "name='" + name + '\'' +
            ", birthDate=" + birthDate +
            ", companyName='" + companyName + '\'' +
            ", companyInn='" + companyInn + '\'' +
            '}';
    }
}
