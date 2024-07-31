package variants_creating_threads.thirst_var;

public class MyThread extends Thread {


    @Override
    public void run() {
        System.out.println("Мы в классе - " + getClass().getSimpleName());
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
