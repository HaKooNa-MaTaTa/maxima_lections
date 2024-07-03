package Inheritance;

public class SportBike extends Moto {

    private String brakes;

    public SportBike(String brand, String model, String power, String brakes) {
        super(brand, model, power);
        this.brakes = brakes;
    }

    @Override
    public void drive() {
        System.out.println("Пишем завещание");
        System.out.println("Оформляем страховку");
        System.out.println("Одеваем экипировку, которая нам не сильно поможет на скорости 100500 км/ч");
        System.out.println("Заводим мотоцикл");
        System.out.println("Крестимся");
        System.out.println("Целуем иконы");
        System.out.println("Стартуем");
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }
}
