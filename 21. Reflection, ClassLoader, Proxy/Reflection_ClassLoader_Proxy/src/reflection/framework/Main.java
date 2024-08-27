package reflection.framework;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        Act act = new Act("Act 10/36", LocalDate.now(), "This act for something");
//        Statement statement = new Statement("Oleg", LocalDate.of(1996, 8, 22));

        DocumentFramework documentFramework = new DocumentFramework();

        Act act = documentFramework.generate(Act.class, "Act 10/36", LocalDate.now(), "This act for something");
        Statement statement = documentFramework.generate(Statement.class, "Oleg", LocalDate.of(1996, 8, 22));
        System.out.println(act);
        System.out.println(statement);
    }
}
