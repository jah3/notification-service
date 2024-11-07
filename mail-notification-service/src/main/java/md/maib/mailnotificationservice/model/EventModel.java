package md.maib.mailnotificationservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventModel{

    private String name;
    private String surname;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "EventModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
