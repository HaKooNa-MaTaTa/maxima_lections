package poly;

public class SportCar extends Car {

    public SportCar(String brand, String model, String color) {
        super(brand, model, color);
    }

    public void drive() {
        System.out.println("Это спорткар");
    }
}
