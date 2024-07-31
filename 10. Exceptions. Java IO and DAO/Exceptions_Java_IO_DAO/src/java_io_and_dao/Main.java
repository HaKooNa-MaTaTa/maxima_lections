package java_io_and_dao;

public class Main {
    public static void main(String[] args) {
        IHumanService service = new HumanService(new HumanDAOInFileMemory());
        Human[] humans = new Human[5];
        humans[0] = new Human("Oleg", "Igonin", "Leopoldovich", 28);
        humans[1] = new Human("Oleg", "Igonin", "Leopoldovich", 2);
        humans[2] = new Human("Oleg", "Igonin", "Leopoldovich", 29);
        humans[3] = new Human("Oleg", "Igonin", "Leopoldovich", 99);
        humans[4] = new Human("Oleg", "Igonin", "Leopoldovich", 299);
        service.create(humans);
    }
}
