package md.maib.mailnotificationservice.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventModel implements Serializable {

    private String name;
    private String surname;
    private int age;
    private String sex;

    @Override
    public String toString() {
        return "EventModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender='" + sex + '\'' +
                '}';
    }
}
