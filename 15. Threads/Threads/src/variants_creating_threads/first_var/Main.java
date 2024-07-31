package variants_creating_threads.first_var;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread("Our First Thread");

        thread.start();
    }
}
