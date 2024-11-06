package md.maib.integrationnotificationservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EventModel implements Serializable{
    private String name;
    private String surname;
    private int age;
    private String gender;
}
