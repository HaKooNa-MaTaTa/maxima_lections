package associations;

public class Car {

    private String brand;
    private String model;
    private String color;

    //Наследование - отношение "IS A"
    //Ассоциация - отношение "HAS A"
    //Два случая ассоциации - композиция и агрегация
    //Композиция - жесткая связь - одно не может существовать без другого
    //Агрегация - мягкая связь - два объекта могут существовать без друг друга
    private Engine engine;

    public Car(String brand,
               String model,
               String color,
               Engine engine) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.engine = engine;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
