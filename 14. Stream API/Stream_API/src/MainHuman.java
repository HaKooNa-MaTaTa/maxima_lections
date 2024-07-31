import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainHuman {

    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();

        humans.add(new Human("Igonin", "Oleg", "Leonidovich", 28));
        humans.add(new Human("Igonin", "Igor", "Leonidovich", 22));
        humans.add(new Human("Igonin", "Vladimir", "Olegovich", 3));
        humans.add(new Human("Igonin", "Varvara", "Olegovna", 4));
        humans.add(new Human("Igonin", "Adelina", "Mihailovna", 27));

        humans.stream()
            .filter(human -> human.getAge() > 10)
            .peek(human -> {
                if (human.getFirstName().equals("Adelina")) {
                    human.setLastName("Badrutdinova");
                }
            })
            .map(Human::toString) //hum -> hum.toString();  :: - квадроточие - это ссылка на метод
            .forEach(System.out::println); // hum -> System.out.println(hum)

    }
}
