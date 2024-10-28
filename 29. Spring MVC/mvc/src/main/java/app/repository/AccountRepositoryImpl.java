package app.repository;

import app.model.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final DataBaseHibernate hibernate;

    @Autowired
    public AccountRepositoryImpl(DataBaseHibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public void signUp(Account account) {
        try (Session session = hibernate.getSession()) {
            session.save(account);
        } catch (RuntimeException e) {
            throw new RuntimeException("Не получилось сохранить:С", e);
        }
    }

    @Override
    public List<Account> getAll() {
        try (Session session = hibernate.getSession()) {
            //Написано на языке HQL
            //SQL -> select * from account, HQL -> from Account
            Query<Account> query = session.createQuery("from Account");
            return query.getResultList();
//            session.createNativeQuery("select * from account");
        } catch (RuntimeException e) {
            throw new RuntimeException("Не получилось получить список пользователей:С", e);
        }
    }
}
