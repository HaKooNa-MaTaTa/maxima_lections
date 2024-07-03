package SOLID.ocr;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Audi", "RS 6");

        car.drive();

        System.out.println("*******************");

        car = new NewCar("Audi", "RS 6");

        car.drive();
    }
}
