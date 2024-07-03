package Inheritance;

public class Main {
    public static void main(String[] args) {
        Moto moto = new Moto("Suzuki", "SX-2000", "500");
        Enduro enduro = new Enduro("KTM", "250", "35", 2);
        SportBike sportBike = new SportBike("Suzuki", "Hayabusa", "1340", "Brembo");
        moto.drive();
        System.out.println("***********************");
        enduro.drive();
        System.out.println("***********************");
        sportBike.drive();
    }
}
