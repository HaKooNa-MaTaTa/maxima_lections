package exceptions;

import java.util.Random;

public class CarShop {

    public static Car sell() {
        Random random = new Random();

        int chance = random.nextInt(10) + 1;

        if (chance > 5) {
            return new Car();
        } else {
            return null;
        }
    }
}
