package md.maib.mailnotificationservice.model;

import lombok.*;

import java.io.Serializable;

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
