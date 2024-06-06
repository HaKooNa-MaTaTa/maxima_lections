import java.util.Scanner;

public class IfElseStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Пожалуйста, введите первое число:");
        int a = scanner.nextInt();
        System.out.println("Пожалуйста, введите второе число:");
        int b = scanner.nextInt();
        int result;

        //ЕСЛИ (УСЛОВИЕ), если оно true/истинно, то мы заходим/проваливаемся внутрь фигурных скобок if,
        //если нет, не истинно - то мы идем дальше и проверяем следующее условие
        if (a > b) {
            System.out.println("Первое число больше второго, вычитаем из первого второе");
            result = a - b;
        } else if (b > a) { //Если условие верно, то проваливаемся сюда и выполняем эту часть кода
            System.out.println("Второе число больше первого, вычитаем из второго первое");
            result = b - a;
        } else { //Если не одно из предыдущих условий не истинно, проваливаемся в этот блок кода
            System.out.println("Оба числа равны");
            result = 0;
        }

        System.out.println("Результат вычитания: ");
        System.out.println(result);

        //Ctrl + /
//        if (b > a) {
//            System.out.println("Второе число больше первого, вычитаем из второго первое");
//            result = b - a;
//        }
//        //Если '=' - то это оператор присвоения, т.е. то, что находится справа от '=' кладется в левую часть от '='
//        //Если '==' - то это оператор сравнения, который выдает либо true - если оба операнда равны, либо false - если один из операндов больше или меньше
//        if (b == a) {
//            System.out.println("Оба числа равны");
//            result = 0;
//        }
    }
}
