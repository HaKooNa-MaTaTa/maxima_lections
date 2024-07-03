package battle_task;

public class MessageReader {

    private final DataSource dataSource;

    public MessageReader(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void newMessage(String message) {
        dataSource.createData(message);
    }
}
