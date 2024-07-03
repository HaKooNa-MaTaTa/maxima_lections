package Inheritance;

import poly.Car;

//Класс-родитель - основной класс, от которого мы будем наследоваться
public class Moto extends Car {

    private String brand;
    private String model;
    private String power;

    public Moto(String brand, String model, String power) {
        super(brand, model, power);
    }

    public void drive() {
        System.out.println("Мы сели на мотоцикл и поехали. Врум-врум-врум!!!!");
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
