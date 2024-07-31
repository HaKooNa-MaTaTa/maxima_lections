package carwash;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        new Car("A060AC716", semaphore);
        new Car("A111AA777", semaphore);
        new Car("A157BB95", semaphore);
        new Car("A100BB01", semaphore);
        new Car("A151CB12", semaphore);
        new Car("A657BD18", semaphore);
    }
}
