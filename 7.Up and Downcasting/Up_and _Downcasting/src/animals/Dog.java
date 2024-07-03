package animals;

public class Dog extends Animal {

    private String nickName;

    public Dog(String color, String nickName) {
        super(color);
        this.nickName = nickName;
    }

    @Override
    public void voice() {
        System.out.println("Гав! Гав! Гав!");
    }

    public void keep() {
        System.out.println("Охраняем кожаный мешок!!");
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
