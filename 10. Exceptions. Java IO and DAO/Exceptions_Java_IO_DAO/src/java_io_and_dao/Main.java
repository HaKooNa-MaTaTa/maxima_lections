package java_io_and_dao;

public class Main {
    public static void main(String[] args) {
        IHumanService service = new HumanService(new HumanDAOInFileMemory());

        service.create(new Human("Oleg", "Igonin", "Leopoldovich", 28));
        service.create(new Human("Ivan", "Ivanov", "Ivanovich", 18));
        service.create(new Human("Petr", "Petrov", "Petrovich", 28));
    }
}
