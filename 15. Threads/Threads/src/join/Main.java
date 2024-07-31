package join;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Worker vikapivatel = new Worker("Выкапыватель");
        Worker taskatel = new Worker("Таскатель");
        Worker zakapivatel = new Worker("Закапыватель");

        System.out.println("Ребят, нужно выкопать здесь яму, перетащить выкопанную землю к другой яме и ее закопать");

//        vikapivatel.setPriority(7);
//        taskatel.setPriority(6);
//        zakapivatel.setPriority(2);

        vikapivatel.start();
        vikapivatel.join(); //Поток, в котором вызвали этот метод, будет ждать окончания работы потока у которого вызван этот метод

        taskatel.start();
        taskatel.join();

        //Потоки-демоны - являются вспомогательными потоками, т.е. не основными.
        zakapivatel.setDaemon(true);
        zakapivatel.start();
    }
}
