package uz.pdp.homework.task4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String lastName;
    private String firstName;
    private String fathersName;
    private String  region;
    private String passport_number;
    private Long inn;
    private Person person;

}
