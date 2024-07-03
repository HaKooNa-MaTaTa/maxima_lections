package animals;

//Класс Обезьяны
public class Animal {

    private String color;

    public Animal(String color) {
        this.color = color;
    }

    public void voice() {
        System.out.println("Ыау ыау ыау");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
