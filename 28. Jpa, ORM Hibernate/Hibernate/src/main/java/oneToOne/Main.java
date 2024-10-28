package oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Passport passport = Passport.builder()
//                .series("1234")
//                .number("123456")
//                .build();
//
//            Person person = Person.builder()
//                .firstName("Oleg")
//                .lastName("Igonin")
//                .patronymic("Leopoldovich")
//                .passport(passport)
//                .build();
//            session.save(passport);
//            passport.setPerson(person);
//            session.save(person);
//            session.update(passport);

            //id=2, id=2
            //id=3, id=2
            int i = 0;
        }
    }
}
