public class NumberUtil {

    public boolean isSimple(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("This version not work with zero and negative numbers");
        }

        if (number == 1 || number == 2 || number == 3) {
            return true;
        }

        //TODO: find this theory
        //number == 11 -> 2, 3, 4, 5, 6, 7, 8, 9
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}
