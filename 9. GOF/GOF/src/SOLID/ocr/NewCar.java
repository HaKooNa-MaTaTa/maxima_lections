package SOLID.ocr;

public class NewCar extends Car {
    public NewCar(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void drive() {
        System.out.println("Добавляем больше механики");
        System.out.println("Ла лала лалал ла");
        super.drive();
    }
}
