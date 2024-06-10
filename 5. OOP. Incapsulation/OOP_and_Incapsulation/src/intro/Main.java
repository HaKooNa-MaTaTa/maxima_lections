package intro;

public class Main {
    public static void main(String[] args) {

        //[ТИП ДАННЫХ ПЕРЕМЕННОЙ] [НАИМЕНОВАНИЕ ОБЪЕКТНОЙ ПЕРЕМЕННОЙ] = [ОПЕРАТОР ВЫДЕЛЕНИЯ ПАМЯТИ И СОЗДАНИЯ ОБЪЕКТА] [ВЫЗОВ НУЖНОГО КОНСТРУКТОРА]
        Human defaultHuman = new Human();
        Human fullHuman = new Human("Oleg", "Igonin", "Leonidovich", 28); //Ctrl + P
        Human ivan = new Human("Ivan", "Ivanov", "Ivanovich", 30);
        //Поля класса - это "состояние" объекта
        //Методы класса - это "поведение" объекта
        System.out.println("defaultHuman");

        defaultHuman.setFirstName("Vanya");

        System.out.println(defaultHuman.getFirstName());
        System.out.println(defaultHuman.getLastName());
        System.out.println(defaultHuman.getPatronymic());
        System.out.println(defaultHuman.getAge());
        defaultHuman.sayHello();
        defaultHuman.sayBye();
        System.out.println("********************");
        System.out.println("fullHuman");
        System.out.println(fullHuman.getFirstName());
        System.out.println(fullHuman.getLastName());
        System.out.println(fullHuman.getPatronymic());
        System.out.println(fullHuman.getAge());
        fullHuman.sayHello();
        fullHuman.sayBye();
        int i = 0;
    }
}
