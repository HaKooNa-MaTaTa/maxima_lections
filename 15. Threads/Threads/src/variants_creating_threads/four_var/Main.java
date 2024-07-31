package variants_creating_threads.four_var;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());

        thread.start();
    }
}
