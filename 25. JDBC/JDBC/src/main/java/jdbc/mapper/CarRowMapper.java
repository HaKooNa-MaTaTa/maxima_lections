package jdbc.mapper;

import jdbc.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Deprecated
public class CarRowMapper implements RowMapper<Car> {

    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Car.builder()
            .id(rs.getLong("id"))
            .brand(rs.getString("brand"))
            .model(rs.getString("model"))
            .color(rs.getString("color"))
            .driver_id(rs.getLong("driver_id"))
            .build();
    }
}
