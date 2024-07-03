package abstraction;

public class Main {
    public static void main(String[] args) {
        Car car = new SportCar("Audi", "RS 6", "White");
        Car car1 = new OffRoadCar("Mitsubishi", "L200", "Blue");

        car.drive();
        car1.drive();
    }
}
