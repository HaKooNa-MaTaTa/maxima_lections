package object;

import java.util.Objects;

public class Car {

    private String brand;

    private String model;

    private String color;

    public Car(String brand, String model, String color) {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Бренд - " + brand + "\n"
            + "Модель - " + model + "\n"
            + "Цвет - " + color;
    }

    @Override
    public boolean equals(Object o) {
        //Если в аргументы объект передал сам себя, то будет true
        if (this == o) {
            return true;
        }
        //Если переданный объект либо null, либо не создан на основе того же класса, что и наш объект
        //то они не могут быть равны
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

}
