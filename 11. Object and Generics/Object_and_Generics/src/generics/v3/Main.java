package generics.v3;

import generics.OffRoadCar;
import generics.SportCar;

public class Main {

    public static void main(String[] args) {
        Garage<SportCar> sportCarGarage = new Garage<>();

        sportCarGarage.inputCar(new SportCar());
        sportCarGarage.inputCar(new OffRoadCar());
    }
}
