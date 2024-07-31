package generics.v1;

import generics.OffRoadCar;
import generics.SportCar;

public class SportCarGarage {

    private int countCars = 0;
    private final SportCar[] cars;

    public SportCarGarage(SportCar ... cars) {
        this.cars = cars;
    }

    public void inputCar(SportCar car) {
        cars[countCars] = car;
        countCars++;
    }

    public SportCar outputCar() {
        if (countCars > 0) {
            return cars[countCars--];
        }

        throw new IllegalStateException("В гараже нет машин");
    }
}
