package base;

import base.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreparedMain {

    public static final String FIND_CAR_BY_ID = "select * from car where id = ? and brand = ?";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/school_maxima",
            "postgres",
            "postgres"
        );

        PreparedStatement preparedStatement = connection.prepareStatement(FIND_CAR_BY_ID);
        preparedStatement.setLong(1, 3);
        preparedStatement.setString(2, "Mercedes-Benz");

        ResultSet result = preparedStatement.executeQuery();
        List<Car> cars = new ArrayList<>();

        while (result.next()) {
            Car car = new Car();
            car.setId(result.getLong("id"));
            car.setBrand(result.getString("brand"));
            car.setModel(result.getString("model"));
            car.setColor(result.getString("color"));
            car.setDriver_id(result.getLong("driver_id"));

            cars.add(car);
        }

        int i = 0;
    }
}
