package battle_task;

public interface DataSource {

    //CRUD - Create Read Update Delete

    Data createData(String message);

    Data read(String id);

    void update(String id, String message);

    void delete(String id);
}
