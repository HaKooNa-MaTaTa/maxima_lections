package base;

import base.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectMain {

    //Задача - сделать так, что бы наше приложение могло работать с базой данных
    //Что нужно, для того, что бы приложение работало с базой данных?
    //1. Нужно знать к чему мы подключаемся? (Что за БД - PostgreSQL, MySQL, MongoDB)
    //2. Куда мы подключаемся? (адрес БД)
    //3. И под кем мы подключаемся?
    public static void main(String[] args) throws SQLException {
        //Объект, через который мы будем работать с БД
        //Просим у DriverManager предоставить соединение с БД
        Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/school_maxima",
            "postgres",
            "postgres"
        );

        Statement statement = connection.createStatement();

        //Хранилище ответа БД на наш запрос.
        ResultSet result = statement.executeQuery("SELECT * FROM car");
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
