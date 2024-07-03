package gof_patterns.singleton;

//Суть паттерна - иметь всего один экземпляр класса (второй создать нельзя)
//и предоставить к объекту глобальный доступ
public class Pattern_Singleton {

    private static Pattern_Singleton instance;
    private final String message;

    private Pattern_Singleton(String message) {
        this.message = message;
    }

    public static Pattern_Singleton getInstance(String message) {
        if (instance == null) {
            instance = new Pattern_Singleton(message);
        }

        return instance;
    }

    public String getMessage() {
        return message;
    }
}
