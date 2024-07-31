package singleton;

public class MySingleton {

    //volatile - отключает кэш у переменной, и теперь эта переменная видна всем потокам,
    //т.е. если один поток ее изменит, то все остальные это увидят
    private volatile static MySingleton instance;

    private final String message;

    private MySingleton(String message) {
        this.message = message;
    }

    //synchronized - ключевое, нужно для контроля потоков
    public static MySingleton getInstance(String message) {
        synchronized (MySingleton.class) {
            if (instance == null) {
                instance = new MySingleton(message);
            }
        }
        return instance;
    }

    public String getMessage() {
        return message;
    }
}
