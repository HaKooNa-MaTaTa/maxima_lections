package classLoader;

public class Main {

    public static void main(String[] args) {
        System.out.println(User.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
    }
}
