package generics.v2;

import generics.CitizenCar;
import generics.OffRoadCar;
import generics.SportCar;

public class Garage {

    private int countSportCar = 0;
    private int countOffRoadCar = 0;
    private int countCitizenCar = 0;

    private OffRoadCar[] offRoadCars;
    private SportCar[] sportCars;
    private CitizenCar[] citizenCars;

    public Garage(OffRoadCar[] offRoadCars, SportCar[] sportCars, CitizenCar[] citizenCars) {
        this.offRoadCars = offRoadCars;
        this.sportCars = sportCars;
        this.citizenCars = citizenCars;
    }

}
