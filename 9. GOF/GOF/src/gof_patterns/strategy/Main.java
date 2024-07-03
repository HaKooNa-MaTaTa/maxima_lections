package gof_patterns.strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = new Client("Oleg");
        Shop shop = new Shop(
                new Product("Mountain Dew", 1500),
                new Product("Milk", 100),
                new Product("Fish", 250),
                new Product("Cheese", 350),
                new Product("Coca Cola", 150)
        );

        System.out.println("Мы подходим на кассу и слышим - 'Как будете расплачиваться?'");
        String choice = scanner.nextLine();

        //equals - сравнивает ссылки двух объектов -> Строка и СТРОКА
        //equalsIgnoreCase - Строка и СТРОКА - одинаково
        if (choice.equalsIgnoreCase(EnumPayStrategy.CASH.toString())) {
            client.setPayStrategy(new Cash(1000));
        } else if (choice.equalsIgnoreCase(EnumPayStrategy.BANK_CARD.toString())) {
            client.setPayStrategy(new BankCard(10000));
        } else if (choice.equalsIgnoreCase(EnumPayStrategy.CREDIT_CARD.toString())) {
            client.setPayStrategy(new CreditCard());
        } else {
            System.out.println("Кассир не понял, как мы будем оплачивать");
            return;
        }

        shop.sell(client);
    }
}
