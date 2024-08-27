package example;

public class Box {

    private String location;
    // И другие поля настройки

    public Box (String location) {
        this.location = location;
    }

    public Box (Box box) {
        this.location = box.location;
    }

}
