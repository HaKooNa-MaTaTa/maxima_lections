package SOLID.srp;

import java.time.LocalDate;

//Есть некий класс, который отвечает за вычисление времени и температуры
public class SRP_Example_Date_and_Temperature {

    private LocalDate localDate;
    private int temperature;

    public SRP_Example_Date_and_Temperature(LocalDate localDate, int temperature) {
        this.localDate = localDate;
        this.temperature = temperature;
    }

    public void calculateLocalDate() {
        localDate = LocalDate.now();
    }

    public void calculateTemperature() {
        temperature = 31;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
