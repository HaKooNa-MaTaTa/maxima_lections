package project.repository.old_version;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import project.dto.SignUpForm;
import project.model.Account;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для работы с базой данных и сущностью {@link Account}
 */
@Repository
public class AccountRepositoryJdbcImpl implements AccountRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_INSERT = "insert into account(id, email, first_name, last_name, password) " +
        "VALUES(:id, :email, :firstName, :lastName, :password); ";

    //language=SQL
    private final String SQL_FIND_BY_ID = "select * from account where id = :id";

    //language=SQL
    private final String SQL_DELETE = "delete from account where id = :id";

    public AccountRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Account> accMapper = ((rs, rowNum) -> Account.builder()
        .id(rs.getLong("id"))
        .email(rs.getString("email"))
        .firstName(rs.getString("first_name"))
        .lastName(rs.getString("last_name"))
        .password(rs.getString("password"))
        .build());

    //TODO:
    @PostConstruct
    private void init() {
    }

    //TODO: попробовать переделать на возврат Account
    //TODO: генерация айдишника на стороне бд
    @Override
    public void save(SignUpForm form) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", (int) (Math.random() * 1000));
        params.put("email", form.getEmail());
        params.put("firstName", form.getFirstName());
        params.put("lastName", form.getLastName());
        params.put("password", form.getPassword());
        jdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public Account findById(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, map, accMapper);
    }

    @Override
    public void deleteById(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        jdbcTemplate.update(SQL_DELETE, map);
    }
}
