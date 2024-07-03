package gof_patterns.strategy;

public class Client {

    private String name;
    private PayStrategy payStrategy;
    private Product[] products;

    public Client(String name) {
        this.name = name;
    }

    public void pay(int cost) {
        payStrategy.pay(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PayStrategy getPayStrategy() {
        return payStrategy;
    }

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product ... products) {
        this.products = products;
    }
}
