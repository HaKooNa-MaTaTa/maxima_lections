package jdbc.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {

    private Long id;
    private String brand;
    private String model;
    private String color;
    private Long driver_id;
}
