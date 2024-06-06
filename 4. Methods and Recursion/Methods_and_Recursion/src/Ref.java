public class Ref {
    public static void main(String[] args) {
        int x = 10;
        int y = 9;
        multiple(x, y, 10, 10, 20, 20);

        System.out.println(x);

        int[] array = {1, 2, 3, 4, 5};
        multiple(array);
    }

    public static void multiple(int number) {
        number = number * number;
    }

    //... - мы указываем, что сюда можно передать либо массив, либо набор элементов (через запятую)
    //в методе этот набор параметров превращается в массив и в методе мы с ним работаем, как с массивом
    public static void multiple(int ... numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[i] * numbers[i];
        }
    }
}
