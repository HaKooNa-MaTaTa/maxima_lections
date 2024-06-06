//Чтобы понять рекурсию, нужно понять рекурсию
public class Recursion {
    public static void main(String[] args) {

        //Рекурсия, это когда метод вызывает сам себя
        //Факториал - умножение всех чисел от 1 до n
        //5! = 1 * 2 * 3 * 4 * 5 = 120
        //5! = 5 * 4 * 3 * 2 * 1 = 120
        //6! = 1 * 2 * 3 * 4 * 5 * 6 = 720
        System.out.println( calculateFactorial(10) );
    }

    /*
    3!
    1 вызов нашего метода:
    number = 3;
    3 != 1
    3 * 2 * 1

    2 вызов нашего метода:
    number = 2;
    2 != 1
    2 * 1

    3 вызов нашего метода:
    number = 1;
    1 == 1

     */

    public static int calculateFactorial(int number) {
        if (number == 1) {
            return number;
        }

        return number * calculateFactorial(number - 1);
    }
}
