package intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
//            Car carOnClass = session.get(Car.class, 4L);
//            //В качестве наименования сущности нужно прописывать значения из маппинга в hibernate.cfg.xml
//            Car carOnString = (Car) session.get("intro.Car", 4L);
//
//            System.out.println("Объект через указание класса - " + carOnClass);
//            System.out.println("Объект через указание имени класса - " + carOnString);

            Car car = Car.builder()
                .brand("Audi")
                .model("RS6")
                .color("Blue")
                .build();

            session.save(car);
        }
    }
}
