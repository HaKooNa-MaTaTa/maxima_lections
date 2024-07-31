package join;

public class Worker extends Thread {

    public Worker (String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Я выполняю свою часть работы, ведь я - " + getName());
        }
    }
}
