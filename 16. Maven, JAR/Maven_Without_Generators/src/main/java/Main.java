public class Main {

    public static void main(String[] args) {
        Car car = new Car("Audi", "RS 6", "Black", 333);

        Car anotherCar = Car.builder()
            .brand("Audi")
            .model("RS 6")
            .color("White")
            .power(333)
            .build();

        System.out.println(car);

        System.out.println(anotherCar);

        System.out.println(car.equals(anotherCar));
    }
}
