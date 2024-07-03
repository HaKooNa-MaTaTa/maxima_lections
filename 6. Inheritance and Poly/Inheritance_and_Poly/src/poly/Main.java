package poly;

import Inheritance.Moto;

public class Main {
    public static void main(String[] args) {
        Car bmw = new SportCar("BMW", "i840", "Black");
        Car audi = new SportCar("Audi", "RS 6", "White");
        Car mercedes = new SportCar("Mercedes-Benz", "Coupe", "Grey");
        Car daewoo = new SportCar("Daewoo", "Nexia", "Rzhavaya");
//        SportCar[] sportCars = {bmw, audi, mercedes, daewoo};

        Car moto = new Moto("sasdas", "asdfas", "asfasgf");
        Car l200 = new OffRoadCar("Mitsubishi", "L200", "Blue");
        Car brabus = new OffRoadCar("Mercedes-Benz", "Brabus", "White");

//        OffRoadCar[] offRoadCars = {l200, brabus};

        Machine machine = new Machine();

        Garage garage = new Garage(bmw, audi, mercedes, daewoo, l200, brabus, moto);

        garage.viewCarsInGarage();
    }
}
