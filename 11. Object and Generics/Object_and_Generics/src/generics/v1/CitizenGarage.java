package generics.v1;

import generics.CitizenCar;

public class CitizenGarage {

    private int countCars = 0;
    private final CitizenCar[] cars;

    public CitizenGarage(CitizenCar ... cars) {
        this.cars = cars;
    }

    public void inputCar(CitizenCar car) {
        cars[countCars] = car;
        countCars++;
    }

    public CitizenCar outputCar() {
        if (countCars > 0) {
            return cars[countCars--];
        }

        throw new IllegalStateException("В гараже нет машин");
    }
}
