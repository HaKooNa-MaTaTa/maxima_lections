package project.repository;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import project.dto.SignUpForm;
import project.model.Account;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Класс для работы с базой данных и сущностью {@link Account}
 */
@Repository
public class AccountRepositoryJdbcImpl implements AccountRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_INSERT = "insert into account(id, email, age, first_name, last_name, patronymic) " +
        "VALUES(:id, :email, :age, :firstName, :lastName, :patronymic); ";

    //language=SQL
    private final String SQL_FIND_BY_ID = "select * from account where id = :id";

    //language=SQL
    private final String SQL_DELETE = "delete from account where id = :id";

    public AccountRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    private static final RowMapper<Account> accMapper = ((rs, rowNum) -> Account.builder()
        .id(rs.getObject("id", UUID.class))
        .email(rs.getString("email"))
        .age(rs.getInt("age"))
        .firstName(rs.getString("first_name"))
        .lastName(rs.getString("last_name"))
        .patronymic(rs.getString("patronymic"))
        .build());

    //TODO:
    @PostConstruct
    private void init() {
    }

    //TODO: попробовать переделать на возврат Account
    @Override
    public void save(SignUpForm form) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", UUID.randomUUID());
        params.put("email", form.getEmail());
        params.put("age", form.getAge());
        params.put("firstName", form.getFirstName());
        params.put("lastName", form.getLastName());
        params.put("patronymic", form.getPatronymic());
        jdbcTemplate.update(SQL_INSERT, params);
    }

    @Override
    public Account findById(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", UUID.fromString(id));
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, map, accMapper);
    }

    @Override
    public void deleteById(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", UUID.fromString(id));
        jdbcTemplate.update(SQL_DELETE, map);
    }
}
