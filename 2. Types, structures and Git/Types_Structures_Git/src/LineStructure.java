import java.util.Scanner;

public class LineStructure {
    public static void main(String[] args) {
        //Волшебная строка, которая позволяет считывать значения с клавиатуры
        Scanner scanner = new Scanner(System.in);

        //System.out.println(содержимое_скобок); - позволяет распечатывать в консоль содержимое скобок
        System.out.println("Пожалуйста, введите первое число:");
        //scanner.nextInt() - берет то число, которое вводит пользователь и кладет его в переменную а
        int a = scanner.nextInt();
        System.out.println("Пожалуйста, введите второе число:");
        //scanner.nextInt() - берет то число, которое вводит пользователь и кладет его в переменную b
        int b = scanner.nextInt();
        //Складываем два числа и результат сложения кладем в переменную с
        int c = a + b;
        System.out.println("Результат сложения: ");
        System.out.println(c);
    }
}


