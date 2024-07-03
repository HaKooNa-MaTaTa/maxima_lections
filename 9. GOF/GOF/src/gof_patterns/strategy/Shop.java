package gof_patterns.strategy;

public class Shop {

    private Product[] products;

    public Shop(Product ... products) {
        this.products = products;
    }

    public void sell(Client client) {
        int finalCost = 0;

        for (Product product : products) {
            finalCost += product.getCost();
        }

        client.getPayStrategy().pay(finalCost);
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
