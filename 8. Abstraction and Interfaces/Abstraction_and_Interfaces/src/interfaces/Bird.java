package interfaces;

public class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Чирик чирик!!");
    }
}
