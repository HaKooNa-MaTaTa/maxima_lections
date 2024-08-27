package reflection.intro;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//Reflection API - это программный интерфейс, благодаря которому
//программа может анализировать и изменять свой код во время выполнения программы
public class Main {
    public static void main(String[] args) {
        User user = new User("Oleg", "Igonin", "Leopoldovich");

//        System.out.println(user.getFirstName());
//        System.out.println(user.getLastName());
//        System.out.println(user.getPatronymic());

        //Class - тип данных, который содержит всю информацию о классе.
//        Class<User> userClass = User.class;
        Class<User> userClass = (Class<User>) user.getClass();

        Field[] fields = userClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        Method[] methods = userClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getReturnType() + " " + method.getName());
        }

        Constructor<User>[] constructors = (Constructor<User>[]) userClass.getConstructors();
        for (Constructor<User> constructor : constructors) {
            System.out.println(constructor.getParameterCount());
        }
    }
}
