import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String brand;
    private String model;

    @EqualsAndHashCode.Exclude
    private String color;

    @EqualsAndHashCode.Exclude
    private int power;
}
