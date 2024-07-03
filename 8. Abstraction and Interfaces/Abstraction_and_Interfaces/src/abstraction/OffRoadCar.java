package abstraction;

public class OffRoadCar extends Car {

    public OffRoadCar(String brand, String model, String color) {
        super(brand, model, color);
    }

    @Override
    public void drive() {
        System.out.println("Я джип и я еду куда хочу");
    }
}
