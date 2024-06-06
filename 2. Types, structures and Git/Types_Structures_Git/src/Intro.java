import java.math.BigInteger;

//class - обозначает класс, после которого идет наименование этого класса
//class Intro
//Внутри фигурных скобок будет находиться все то, что принадлежит классу
public class Intro {
    //psvm
    //main

    //Это точка входа в программу, т.е. программа начинает свою работу внутри
    //фигурных скобок метода main
    public static void main(String[] args) {
        //Код пишется здесь

        //Переменная - это именнованная область памяти, в которой можно хранить информацию.
        //[тип_данных_переменной] [наименование переменной]
        byte a; //от -128 до 127 (занимает 1 байт) -2^7 До 2^7-1
        //(byte) - явное преобразование. Т.е. разработчик сам указывает, что понимает, что идет
        //потеря данных и он берет все риски на себя
        byte a1 = (byte) -1000; //-1000 -128
        //-----
        short b; // от -32768 до 32767 (занимает 2 байта) от -2^15 до 2^15-1

        short b1 = 31000;

        //-----
        //Объявление переменной - мы резервируем имя и место в памяти, но не кладем значение в переменную.
        int c; // от -2.147.483.648 до 2.147.483.647 (занимает 4 байта) от -2^31 до 2^31-1
        //Объявление + инициализация переменной - все тоже самое, что и в объявление + кладем значение.
        int c1 = 1_345_279;
        //-----

        //Инициализация переменной
        int variable = 1_000;


        long d; // 8 байт, -2^63 До 2^63-1
        long d1 = 10_000_000_000L;

        //---------------
        float f; //4 байта, -3.4E+38 До 3.4E+38
        float f1 = 1.5f;

        //TODO: арифметика с float и double
        //-----
        double e; //8 байт, -1.7Е+308 до 1.7Е+308
        double e1 = 1.5;

        double test = 1.0 / 0.3;
        //Магическое выражение, которое распечатывает в консоль то, что мы положим внутрь скобок
//        System.out.println(test);

        //-----
        char g = '\u8723'; //2 байта,

        //System.out.println(g);

        //----
        boolean bool; // true/false
        bool = true;
        bool = false;

        //--------
        //Ссылочный тип данных - все остальное, что есть в Java.

        String text = "Abrakadabra!";
        System.out.println("';lkzxfbckl;j'bsvcxjlk");

        int primitive = 1;
        String hello = "hello";
    }
}


