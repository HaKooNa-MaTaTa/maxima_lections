package Incapsulation;


//Машина, у которой будет марка, модель, количество лошадиных сил
public class Car {

    public static String someField;
    private String brand;
    private String model;
    private int power;

    public Car(String brand, String model, int power) {
        this.brand = brand;
        this.model = model;
        if (power <= 0) {
            this.power = 100;
        } else {
            this.power = power;
        }
    }

    //Сделаем метод "изображающий работу автомобиля"
    public void powerOn() {
        System.out.println("Садимся в машину");
        System.out.println("Закрываем дверь");
        System.out.println("Заводим машину");
        engineOn();
        //Еще куча вспомогательных скрытых и не обязательно скрытых методов
    }

    public static void someMethod() {
        System.out.println("Тестируем ключевое слово static");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        System.out.println("Получение модели машины");
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        System.out.println("Получение мощности");
        return power;
    }

    public void setPower(int power) {
        if (power <= 0) {
            this.power = 100;
            return;
        }
        this.power = power;
    }

    private void engineOn() {
        System.out.println("Начинает крутиться стартер");
        System.out.println("Подается смесь в цилиндры");
        System.out.println("Двигатель делает - Бубубу");
    }

    private void engineOff() {
        System.out.println("Что то происходит");
        System.out.println("Двигатель делает грустное Бубубу и замолкает");
    }
}
