package interfaces;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Airplane airplane = new Airplane();
        Phanera phanera = new Phanera();
        Star star = new Star();

        Flyable[] flyables = {bird, airplane, phanera, star};

        //for-each
        // ТИП ДАННЫХ ПЕРЕМЕННАЯ : НАБОР ДАННЫХ ТОГО ЖЕ ТИПА, ЧТО И ПЕРЕМЕННАЯ

        //for (БЕРЕМ КАКУЮ ТО КНИГУ ИЗ ШКАФА С КНИГАМИ) { }
        for (Flyable flyable : flyables) {
            flyable.fly();
        }
    }
}
