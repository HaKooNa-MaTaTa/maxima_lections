package variants_creating_threads.four_var;

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("А теперь мы имплементировали интерфейс Runnable");
    }
}