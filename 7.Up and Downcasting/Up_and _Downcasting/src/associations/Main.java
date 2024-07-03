package associations;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(122, 1.8, 16);
        Car car = new Car("Lada", "Vesta", "Black", engine);

        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getColor());
        System.out.println(car.getEngine().getPower());
        System.out.println(car.getEngine().getCountValve());
        System.out.println(car.getEngine().getV());
    }
}
