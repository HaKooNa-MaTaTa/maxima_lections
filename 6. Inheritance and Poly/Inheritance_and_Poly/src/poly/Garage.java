package poly;

public class Garage {

    private Car[] cars;

    public Garage(Car ... cars) {
        this.cars = cars;
    }

    public void viewCarsInGarage() {
        Car car;

        for (int i = 0; i < cars.length; i++) {
            car = cars[i];
            System.out.println("Я сейчас смотрю на - " + car.getBrand() + " " + car.getModel() + " " + car.getColor());
        }
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
