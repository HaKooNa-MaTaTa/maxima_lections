package java_io_and_dao;

//DAO - Data Access Object

import java.io.IOException;

//Будет:
//Сущность Human
//Интерфейс HumanDAO, который описывает все действия в хранилище данных с сущностью Human
//Реализация этого интерфейса
//Сервис, который будет пользоваться этим интерфейсом
public interface IHumanDAO {
    //CRUD -> Create Read Update Delete
    Human create(Human human);
    Human create(Human[] humans);

    Human findById(int id);

    void update(Human human);

    void delete(int id);
}
