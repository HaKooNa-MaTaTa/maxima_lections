package mvc.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class HiberSessionUtil implements DataBaseHiber {

    private final SessionFactory sessionFactory;

    public HiberSessionUtil() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
