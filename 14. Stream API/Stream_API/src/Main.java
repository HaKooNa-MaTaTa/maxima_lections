import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //Stream API - это инструмент для работы со структурами данных в функциональном стиле.
        //object.method1()
        // .method2()
        // .method3();

        //В Stream API есть два типа методов:
        //1. Конвейерный тип - это промежуточный тип методов. Т.е. на вход метод принимает
        //один Stream, на выходе отдает либо тот же самый Stream, либо измененный
        //2. Терминальный тип - это конечный тип методов. Т.е. на вход метод принимает
        //Stream, на выходе выдается конкретный результат. Например - список объектов.
        Random random = new Random();

        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));
        list.add(random.nextInt(100));

        System.out.println("Полученный лист");
        System.out.println(list);

        //Для того что бы работать со структурой данных с помощью Stream API
        //ее, структуру, нужно преобразовать в Stream (в поток)
        //Лямбда выражения - это анонимные классы, которые могут имплементировать функциональные интерфейсы
        //() -> сама реализация
        //num -> num > 50
//        list.stream()
//            .filter(num -> num > 50)
//            .forEach(num -> System.out.println(num));

        List<String> strokes = list.stream()
            .distinct()
            .map(String::valueOf)
            .collect(Collectors.toList());

        System.out.println(strokes);
        int i = 0;
    }
}
