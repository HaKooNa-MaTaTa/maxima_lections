package gof_patterns.strategy;

public class CreditCard implements PayStrategy {
    @Override
    public void pay(int cost) {
        System.out.println("у меня есть кредитка, плевать на стоимость");
        System.out.println("Оплата, ЕСТЕСТВЕННО, прошла, иду домой");
    }

    @Override
    public int getBalance() {
        return Integer.MAX_VALUE;
    }
}
