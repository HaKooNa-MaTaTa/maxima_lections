package battle_task;

public class Main {
    public static void main(String[] args) {
        MessageReader messageReader = new MessageReader(new DataSourceDataBase());

        messageReader.newMessage("1");
        messageReader.newMessage("2");
        messageReader.newMessage("3");
        messageReader.newMessage("4");
        messageReader.newMessage("5");
        messageReader.newMessage("6");
        messageReader.newMessage("7");
        messageReader.newMessage("8");
        messageReader.newMessage("9");
        messageReader.newMessage("10");
        messageReader.newMessage("11");
    }
}
