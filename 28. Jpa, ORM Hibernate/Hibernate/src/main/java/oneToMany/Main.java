package oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Airplane airplane = Airplane.builder()
//                .name("Boeing")
//                .build();
//
//            Passenger passenger1 = Passenger.builder()
//                .firstName("firstName1")
//                .lastName("lastName1")
//                .airplane(airplane)
//                .build();
//
//            Passenger passenger2 = Passenger.builder()
//                .firstName("firstName2")
//                .lastName("lastName2")
//                .airplane(airplane)
//                .build();
//
//            Passenger passenger3 = Passenger.builder()
//                .firstName("firstName3")
//                .lastName("lastName3")
//                .airplane(airplane)
//                .build();
//
//            session.save(airplane);
//            session.save(passenger1);
//            session.save(passenger2);
//            session.save(passenger3);

            Airplane airplane = session.get(Airplane.class, 1L);

            int i = 0;
        }
    }
}
