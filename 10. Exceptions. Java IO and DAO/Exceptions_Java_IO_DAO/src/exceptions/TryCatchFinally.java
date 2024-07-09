package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchFinally {
    public static void main(String[] args) {
        int a = 10;
        Scanner scanner = new Scanner(System.in);

        try {
            a = scanner.nextInt();
        } catch (InputMismatchException e) {
            a = 20;
        } finally {
            a = 30;
        }

        System.out.println(a);
    }
}
