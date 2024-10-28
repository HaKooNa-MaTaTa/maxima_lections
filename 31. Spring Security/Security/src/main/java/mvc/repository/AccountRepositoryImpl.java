package mvc.repository;

import mvc.model.Account;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {


    private DataBaseHiber dataBaseHiber;

    @Autowired
    public AccountRepositoryImpl(DataBaseHiber dataBaseHiber) {
        this.dataBaseHiber = dataBaseHiber;
    }

    @Override
    public void save(Account account) {
        try(Session session = dataBaseHiber.getSession()) {
            session.save(account);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        try(Session session = dataBaseHiber.getSession()) {
            NativeQuery<Account> query = session.createNativeQuery("select * from account", Account.class);
            return query.getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getByEmail(String email) {
        try(Session session = dataBaseHiber.getSession()) {
            String sql = String.format("select * from account where email = %s", email);
            NativeQuery<Account> query = session.createNativeQuery(sql, Account.class);
            return query.getSingleResult();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
