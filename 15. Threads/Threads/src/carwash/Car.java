package carwash;

import java.util.concurrent.Semaphore;

public class Car extends Thread {

    private String number;

    private Semaphore semaphore;

    public Car(String number, Semaphore semaphore) {
        this.number = number;
        this.semaphore = semaphore;
        start();
    }

    @Override
    public void run() {
        System.out.println(number + " стоит в очереди на автомойку");
        try {
            //Забираем пропуск у семафора
            semaphore.acquire();
            System.out.println(number + " заехал в бокс");
            Thread.sleep(1000);
            System.out.println(number + " начал мыться");
            Thread.sleep(1000);
            System.out.println(number + " помылся");
            Thread.sleep(1000);
            System.out.println(number + " выехал из бокса");
            Thread.sleep(1000);
            semaphore.release(); //возвращаем пропуск обратно
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
