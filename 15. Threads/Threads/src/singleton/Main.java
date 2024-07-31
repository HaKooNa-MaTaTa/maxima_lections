package singleton;

import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
//        MySingleton mySingleton1 = MySingleton.getInstance("FOO");
//        MySingleton mySingleton2 = MySingleton.getInstance("BAR");
//
//
//        System.out.println(mySingleton1.getMessage());
//        System.out.println(mySingleton2.getMessage());

        Thread foo = new Thread(() -> {
            System.out.println("Это поток FOO");
            MySingleton singleton = MySingleton.getInstance("FOO");
            System.out.println(singleton.getMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new InputMismatchException(e.getMessage());
            }
            System.out.println(singleton.getMessage());
        });

        Thread bar = new Thread(() -> {
            System.out.println("Это поток BAR");
            MySingleton singleton = MySingleton.getInstance("BAR");
            System.out.println(singleton.getMessage());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new InputMismatchException(e.getMessage());
            }
            System.out.println(singleton.getMessage());
        });

        foo.start();
        bar.start();
    }

}
