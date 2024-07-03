package interfaces;

public class Star implements Flyable {
    @Override
    public void fly() {
        System.out.println("Я где то в космосе летаю");
    }
}
