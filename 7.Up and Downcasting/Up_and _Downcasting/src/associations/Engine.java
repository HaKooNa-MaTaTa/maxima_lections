package associations;

public class Engine {

    private int power;
    private double v;
    private int countValve;

    public Engine(int power, double v, int countValve) {
        this.power = power;
        this.v = v;
        this.countValve = countValve;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public double getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getCountValve() {
        return countValve;
    }

    public void setCountValve(int countValve) {
        this.countValve = countValve;
    }
}
