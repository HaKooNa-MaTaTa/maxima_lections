package java_io_and_dao;

import java.io.IOException;

public interface IHumanService {

    Human create(Human human);
    Human create(Human[] human);

    Human findById(int id);

    void update(Human human);

    void delete(int id);
}
