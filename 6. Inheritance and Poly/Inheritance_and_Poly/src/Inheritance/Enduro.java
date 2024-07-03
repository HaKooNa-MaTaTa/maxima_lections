package Inheritance;

//Enduro - Это тоже мотоцикл, поэтому мы с вами можем наследоваться от общего класса Moto
public class Enduro extends Moto {

    private int countStroke;
    private boolean carbOn;

    //ВАЖНО - если у предка есть свой конструктор, то:
    //1. Класс потомок обязан иметь свой конструктор
    //2. Внутри конструктора потомка мы в первую очередь вызываем конструктор предка
    public Enduro(String brand, String model, String power, int countStroke) {
        //super() - вызов конструктора предка
        super(brand, model, power);
        this.countStroke = countStroke;
        this.carbOn = false;
    }

    //@Override - аннотация, которая показывает, что данный метод принадлежит предку и мы его переопределяем.
    @Override
    public void drive() {
        //super. - обращение к предку
        //super.drive();
        System.out.println("Мы катаемся на - " + getBrand());
        carbOn();
        powerOn();
        warmingUp();
        carbOff();
        System.out.println("Едем по лесам, по полям, по болотам. Дряяяяяянь-дряяянь-дрянь!!!!");
        powerOff();
    }

    private void carbOn() {
        System.out.println("Поднимаем подсос на карбюраторе");
        this.carbOn = true;
    }

    private void warmingUp() {
        System.out.println("Прогреваем мотоцикл");
    }

    private void powerOn() {
        System.out.println("Заводим мотоцикл");
    }

    private void powerOff() {
        System.out.println("Глушим мотоцикл");
    }

    private void carbOff() {
        System.out.println("Опускаем подсос на карбюраторе");
        this.carbOn = false;
    }

    public int getCountStroke() {
        return countStroke;
    }

    public void setCountStroke(int countStroke) {
        this.countStroke = countStroke;
    }
}
