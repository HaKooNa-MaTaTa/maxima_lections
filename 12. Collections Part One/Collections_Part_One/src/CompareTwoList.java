import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CompareTwoList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Заполняем LinkedList");
//        addDefaultElements(linkedList);
        addElementsInBeginInLinkedList(linkedList);
        System.out.println("Заполняем ArrayList");
//        addDefaultElements(arrayList);
        addElementsInBegin(arrayList);
        System.out.println("Вытаскиваем элемент по индексу из ArrayList`a");
        getElementByIndex(arrayList, 5_000_000);
        System.out.println("Вытаскиваем элемент по индексу из LinkedList`a");
        getElementByIndex(linkedList, 5_000_000);
    }


    public static void addDefaultElements(List<Integer> list) {
        Date start = new Date();

        for (int i = 0; i < 100_000_000; i++) {
            list.add(i);
        }

        Date end = new Date();

        System.out.println("Лист заполнился за - " + (end.getTime() - start.getTime()));
    }

    public static Integer getElementByIndex(List<Integer> list, int index) {
        Date start = new Date();
        int result = list.get(index);
        Date end = new Date();

        System.out.println("Элемент был вытащен за - " + (end.getTime() - start.getTime()));
        return result;
    }

    public static void addElementsInBegin(List<Integer> list) {
        Date start = new Date();

        for (int i = 0; i < 10_000_000; i++) {
            list.add(0, i);
        }

        Date end = new Date();

        System.out.println("Лист заполнился при вставке в начало за - " + (end.getTime() - start.getTime()));
    }

    public static void addElementsInBeginInLinkedList(LinkedList<Integer> list) {
        Date start = new Date();

        for (int i = 0; i < 10_000_000; i++) {
            list.addFirst(i);
        }

        Date end = new Date();

        System.out.println("Лист заполнился при вставке в начало за - " + (end.getTime() - start.getTime()));
    }
}
