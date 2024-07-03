package interfaces;

public class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Я - Боинг, лучше на мне не летать");
    }
}
