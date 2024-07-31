package map.poker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        //Раздать карты
        //Посмотреть, какая комбинация на столе
        //Определить комбинацию
        Random random = new Random();
        Card[] tableCards = new Card[5];

        for (int i = 0; i < tableCards.length; i++) {
            tableCards[i] = Card.values()[random.nextInt(Card.values().length)];
        }

        System.out.println(Arrays.toString(tableCards));

        Map<Card, Integer> map = new HashMap<>();

        for (int i = 0; i < tableCards.length; i++) {
            if (map.containsKey(tableCards[i])) {
                int temp = map.get(tableCards[i]);
                map.put(tableCards[i], temp + 1);
            } else {
                map.put(tableCards[i], 1);
            }
        }
        //1 key
        // K K K K K - жульничество
        //2 keys
        // K K K Q Q - full house (K, 3), (Q, 2)
        // K K K K Q - kare       (K, 4), (Q, 1)
        //3 keys
        // K Q J J J - set
        // K K Q Q J - two pair
        //4 keys
        // K K Q J T - pair
        //5 keys
        // T J Q K A - high card

        switch (map.size()) {
            case 1:
                System.out.println("КАЗИНО ЖУЛЬНИЧАЕТ!!!!!!!");
                break;
            case 2:
                if (map.containsValue(4)) {
                    System.out.println("На столе лежит каре");
                } else {
                    System.out.println("На столе лежит фул хаус");
                }
                break;
            case 3:
                if (map.containsValue(3)) {
                    System.out.println("На столе лежит сет");
                } else {
                    System.out.println("На столе лежат две пары");
                }
                break;
            case 4:
                System.out.println("На столе лежит пара");
                break;
            case 5:
                System.out.println("Все пять карт разные. Лошара!");
        }
    }

//    private static boolean checkValues(Map<Card, Integer> map, int checkValue) {
////        List<Integer> list = new ArrayList<>(map.values());
////
////        for (Integer integer : list) {
////            if (integer == checkValue) {
////                return true;
////            }
////        }
////
////        return false;
//
//
//    }
}
