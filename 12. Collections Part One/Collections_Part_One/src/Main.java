import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
//        int[] array = new int[10];
//
//        for (int i = 0; i < 100; i++) {
//            if (i < array.length) {
//                array[i] = i + i;
//            } else {
//
//                array = new int[array.length * 2];
//            }
//        }

//        Integer a = 10;
//        int b = a;
//        List<Integer> numbers = new ArrayList<>();
//
//        for (int i = 0; i < 1_00; i++) {
//            numbers.add(i);
//        }
//
//        //System.out.println(numbers.get(1_000));
//        Predicate<Integer> predicate = new PredicateOnOddNumber();
//        numbers.removeIf(predicate);
//
//        int i = 0;

        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add(i);
        }
    }

}
