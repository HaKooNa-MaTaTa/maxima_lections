package abstraction;

public class SportCar extends Car {

    public SportCar(String brand, String model, String color) {
        super(brand, model, color);
    }

    @Override
    public void drive() {
        System.out.println("Я спорткар. Я лечу куда хочу!");
    }
}
