package base.model;

import lombok.Data;

@Data
public class Car {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private Long driver_id;
}
