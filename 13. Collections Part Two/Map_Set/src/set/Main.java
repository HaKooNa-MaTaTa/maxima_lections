package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    //Set - множество уникальных элементов
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(10);
        set.add(12);
        set.add(12);
        set.add(13);
        set.add(13);
        set.add(15);


        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        System.out.println("Проверка");
        System.out.println(iterator.next());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.next();
    }

}
