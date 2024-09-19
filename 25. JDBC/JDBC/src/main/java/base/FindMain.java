package base;

import base.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMain {

    public static final String FIND_ALL_CARS = "select * from car";

    public static final String FIND_CAR_BY_ID = "select * from car where id=";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/school_maxima",
            "postgres",
            "postgres"
        );

        Statement statement = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите Id машины, которую хотите посмотреть");
        String id = scanner.nextLine();
        //2 -> select * from car where id=2
        //2; delete from car where id=2 -> select * from car where id=2; delete from car where id=2
        //Хранилище ответа БД на наш запрос.
        ResultSet result = statement.executeQuery(FIND_CAR_BY_ID + id);
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
