package app.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

@Service
public class DataBaseHibernateImpl implements DataBaseHibernate {

    private final SessionFactory sessionFactory;

    public DataBaseHibernateImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
