package gof_patterns.strategy;

public class BankCard implements PayStrategy {

    private int balance;

    public BankCard(int balance) {
        this.balance = balance;
    }

    @Override
    public void pay(int cost) {
        System.out.println("Расплачусь картой");

        if (balance - cost >= 0) {
            System.out.println("Ехоу, денег хватило, иду домой");
            balance -= cost;
        } else {
            System.out.println("Денег не хватило, надо больше работать, меньше кушать");
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
