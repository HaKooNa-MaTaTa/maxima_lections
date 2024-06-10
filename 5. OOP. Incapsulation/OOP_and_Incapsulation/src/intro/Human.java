package intro;

//Для решения нашей задачи нам необходимо создать класс Человек, который будет уметь здороваться и прощаться.
//Так же, у Человека будет возраст, имя, фамилия и отчество
public class Human {

    //1. Поля класса
    //[МОДИФИКАТОР_ДОСТУПА] [static / not static] [ТИП_ДАННЫХ] [НАИМЕНОВАНИЕ_ПОЛЯ];
    //если у класс/метода/переменной стоит ключевое слово static - это означает, что данный член класса принадлежит самому классу, а не объекту
    //т.е. в объект он не попадет.
    //Т.к. поле или метод принадлежат классу, то они существуют в единственном экземпляре.
    private String firstName; //null
    private String lastName;
    private String patronymic;
    private int age; //0 -> double, float -> 0.0

    //2. Конструкторы класса
    //Конструктор - это набор инструкций для инициализации полей объекта.
    //[МОДИФИКАТОР_ДОСТУПА] [НАИМЕНОВАНИЕ_КОНСТРУКТОРА ([ДАННЫЕ ДЛЯ ИНИЦИАЛИЗАЦИИ ПОЛЕЙ]) (всегда совпадает с наименованием класса)] { //инициализация полей }
    public Human () {
        firstName = "Ivan";
        lastName = "Ivanov";
        patronymic = "Ivanovich";
        age = 30;
    }

    //this.firstName = firstName;
    public Human (String name, String middleName, String otchestvo, int humanAge) {
        firstName = name;
        lastName = middleName;
        patronymic = otchestvo;
        age = humanAge;
    }

    //Alt + Insert
    public Human(String firstName, String lastName, String patronymic) {
        this.firstName = firstName; //this. - ссылка на самого себя
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    //3. Методы класса
    public void sayHello() {
        System.out.println("Привет!");
    }

    public void sayBye() {
        System.out.println("Пока!");
    }

    //firstName
    //Getter
    public String getFirstName() {
        return firstName;
    }
    //Setter
    public void setFirstName(String name) {
        firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
