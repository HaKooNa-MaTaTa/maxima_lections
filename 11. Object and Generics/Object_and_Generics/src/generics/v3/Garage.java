package generics.v3;

import generics.CitizenCar;
import object.Car;

//<> - diamonds явный признак что перед нами - generic
//Generic`s - Нужны для обобщенного программирования, т.е. для создания какой то общей функциональности,
//либо привязанной к какому то классу частично, либо не привязана вообще
//T, K, V - элемент, ключ, значение
public class Garage<T> {

    private int countCars = 0;
    private final T[] cars = (T[]) new Object[10];

    public Garage() {}

    public void inputCar(T car) {
        cars[countCars] = car;
        countCars++;
    }

    public T outputCar() {
        if (countCars > 0) {
            return cars[countCars--];
        }

        throw new IllegalStateException("В гараже нет машин");
    }
}
