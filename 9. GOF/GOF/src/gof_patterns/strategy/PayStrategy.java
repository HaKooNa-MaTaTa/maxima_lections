package gof_patterns.strategy;

public interface PayStrategy {

    void pay (int cost);
    int getBalance();
}
