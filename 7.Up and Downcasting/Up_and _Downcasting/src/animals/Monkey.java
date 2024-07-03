package animals;

public class Monkey extends Animal {

    private String name;
    private int legs;
    private int arms;
    public Monkey(String color, String name, int legs, int arms) {
        super(color);
        this.name = name;
        this.legs = legs;
        this.arms = arms;
    }

    @Override
    public void voice() {
        System.out.println("Сам ты обезьяна. Я - примат!!!");
    }

    public void jump() {
        System.out.println("Примат " + name + " прыгает!!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getArms() {
        return arms;
    }

    public void setArms(int arms) {
        this.arms = arms;
    }
}
