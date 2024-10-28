package intro;

//Для того, что бы класс мог использоваться Hibernate`ом, он должен быть POJO
//POJO - Plain Old Java Object:
//1. Класс не должен быть конечным (без модификатора final)
//2. Поля класса тоже не должны быть финальными
//3. Обязательно должен быть пустой конструктор (при этом, могут быть и другие конструкторы)
//4. Поля должны быть приватными, а доступ к ним через геттеры и сеттеры
//5. У класса должны быть две аннотации - @Entity и @Id

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;
}
