package generics.v1;

import generics.CitizenCar;
import generics.OffRoadCar;

public class OffRoadGarage {
    private int countCars = 0;
    private final OffRoadCar[] cars;

    public OffRoadGarage(OffRoadCar ... cars) {
        this.cars = cars;
    }

    public void inputCar(OffRoadCar car) {
        cars[countCars] = car;
        countCars++;
    }

    public OffRoadCar outputCar() {
        if (countCars > 0) {
            return cars[countCars--];
        }

        throw new IllegalStateException("В гараже нет машин");
    }
}
