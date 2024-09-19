package jdbc;

import jdbc.mapper.CarRowMapper;
import jdbc.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(new DriverManagerDataSource(
            "jdbc:postgresql://localhost:5432/school_maxima",
            "postgres",
            "postgres"));

//       Integer count = jdbcTemplate.queryForObject("select count(*) from car", Integer.class);
       List<Car> car = jdbcTemplate.query("select * from car", new CarRowMapper());
       int a = jdbcTemplate.update("update car set brand = 'Lada' where id = 1");
       jdbcTemplate.queryForObject()
       int i = 0;
    }
}
