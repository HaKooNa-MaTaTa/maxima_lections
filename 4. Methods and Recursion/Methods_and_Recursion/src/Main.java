import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        int c = a + b;
//
//        System.out.println(c);
//
//        int d = scanner.nextInt();
//        int result = c + d;
//
//        System.out.println(result);
//
//        result += result; //result = result + result;
//
//        System.out.println(result);

//        sumTwoNumbers();
//        sumTwoNumbers();
//        sumTwoNumbers();

        int result = sumTwoNumbers(10, 10);
        System.out.println(result);
        result = sumTwoNumbers(20, 20);
        System.out.println(result);
    }

    //Метод - именованный кусок кода, который можно вызвать по имени и запустить его.
    //void - указывает на то, что данный метод ничего не возвращает.
    //Процедура - вид метода, когда метод ничего не возвращает в место вызова.
    public static void sumTwoNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два числа");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a < 0) {
            System.out.println("Первое число - отрицательное. Вычисление отменено.");
            return;
        }

        int c = a + b;

        System.out.println("Результат сложения - " + c);
    }

    //Перегрузка метода - метод имеет несколько версий, которые различаются между собой
    //набором формальных параметров
    //Формальные параметры - то, что указано в скобках метода
    //Функция - вид метода, который явно возвращает результат своей работы.
    public static int sumTwoNumbers(int number1, int number2) {
        //int result = number1 + number2;

        //оператор return используется в двух случаях:
        //1. Когда нужно вернуть результат вычисления метода.
        //2. Когда нужно выйти из метода.
        return number1 + number2;
    }


}
