package variants_creating_threads.second_var;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Всем привет");
            System.out.println("Мы создаем новый поток");
            System.out.println("Да, собственное, мы его уже создали");
            System.out.println("Раз виден этот текст, значит поток уже запущен");
            System.out.println("И выполняет свою работу");
        });

        thread.start();
        Thread.sleep(1);
        System.out.println("This text is in main thread");
        System.out.println("And i dont know what i want to write");
        System.out.println("A");
        System.out.println("b");
        System.out.println("bC");
        System.out.println("D");
    }
}
