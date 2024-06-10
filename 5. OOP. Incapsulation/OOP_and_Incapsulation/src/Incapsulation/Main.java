package Incapsulation;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mitsubishi", "L200", -1);

        car.setPower(-10);
        Car.someMethod();
        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getPower());

        car.powerOn();
    }
}
