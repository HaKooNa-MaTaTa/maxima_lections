package animals;

public class Human extends Monkey {

    private String lastName;
    private String patronymic;

    public Human(String color, String name, int legs, int arms, String lastName, String patronymic) {
        super(color, name, legs, arms);
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    @Override
    public void voice() {
        System.out.println("Сам ты примат. Я - " + this.lastName + " " + this.getName() + " " + this.patronymic);
    }

    @Override
    public void jump() {
        System.out.println(this.lastName + " " + this.getName() + " " + this.patronymic + " - прыгает!");
    }

    public void work() {
        System.out.println(this.lastName + " " + this.getName() + " " + this.patronymic + " - идет на работу!");
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
}
