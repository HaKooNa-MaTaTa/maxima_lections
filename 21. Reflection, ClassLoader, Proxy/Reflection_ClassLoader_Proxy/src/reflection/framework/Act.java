package reflection.framework;

import java.time.LocalDate;

//Акт
public class Act {

    private String name;
    private LocalDate date;
    private String description;
    @DefaultValue("Igonin Oleg")
    private String from;

    public Act(String name, LocalDate date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Act{" +
            "name='" + name + '\'' +
            ", date=" + date +
            ", description='" + description + '\'' +
            ", from='" + from + '\'' +
            '}';
    }
}
