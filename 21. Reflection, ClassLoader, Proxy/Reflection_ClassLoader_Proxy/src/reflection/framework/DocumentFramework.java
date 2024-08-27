package reflection.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DocumentFramework {

    //Class<User> userClass, "Oleg", "Igonin"
    public <T> T generate(Class<T> clazz, Object ... args) {

        //1. Нам нужно получить типы данных наших аргументов
        //2. Получив типы данных наших аргументов, мы сможем найти подходящий конструктор,
        //для создания нашего объекта
        //3. Получив нужный конструктор - мы создаем объект и отдаем его
        List<Class<?>> argsType = new ArrayList<>();
        //Вытаскиваем у каждого аргумента его тип данных (его класс)
        for (Object obj : args) {
            argsType.add(obj.getClass());
        }

        //Засовываем все это в массив
        //[String, String]
        Class<?>[] argsTypeToArray = new Class[argsType.size()];
        argsType.toArray(argsTypeToArray);

        //User
        //1. String
        //2. String, String
        //3. String, String, String

        //[String, String]
        try {
            //Ищем подходящий конструктор
            Constructor<T> constructor = clazz.getConstructor(argsTypeToArray);
            //"Oleg", "Igonin"
            T doc = constructor.newInstance(args);
            processDefaultValue(doc);
            return doc;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> void processDefaultValue(T doc) {
        Class<T> clazz = (Class<T>) doc.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            DefaultValue defaultValue = field.getAnnotation(DefaultValue.class);
            if (defaultValue != null) {
                try {
                    field.setAccessible(true);
                    field.set(doc, defaultValue.value());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
