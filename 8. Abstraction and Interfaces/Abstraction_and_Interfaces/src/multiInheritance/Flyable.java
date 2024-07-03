package multiInheritance;

public interface Flyable {

    default void fly() {
        System.out.println("Fly!");
    }
}
