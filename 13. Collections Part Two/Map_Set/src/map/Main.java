package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //Есть числовая последовательность и нам нужно посчитать, сколько и каких было чисел
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        //List<Integer> numbers = new ArrayList<>();
        //Сначала указываем тип данных ключа, а потом указываем тип данных значения
        Map<Integer, Integer> numbers = new HashMap<>();
        //"Oleg" -> 23451 >> 1
        while (i > 0) {
            if (numbers.get(i) != null) {
                int oldValue = numbers.get(i);
                numbers.put(i, oldValue + 1);
            } else {
                numbers.put(i, 1);
            }
            i = scanner.nextInt();
        }

        //Пройтись по списку и найти самое большое число
        //Создать массив, длина которого равна самому большому числу
        //Проходим второй раз по списку и
        //25 -> array[25] +1


    }

}
