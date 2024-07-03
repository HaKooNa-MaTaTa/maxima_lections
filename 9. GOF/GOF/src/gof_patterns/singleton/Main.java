package gof_patterns.singleton;

public class Main {
    public static void main(String[] args) {
        Pattern_Singleton singleton1 = Pattern_Singleton.getInstance("message");

        Pattern_Singleton singleton2 = Pattern_Singleton.getInstance("message 2");


        System.out.println(singleton1.getMessage());
        System.out.println(singleton2.getMessage());
    }
}
