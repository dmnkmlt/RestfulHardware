package hr.java.spring.boot.University.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

    private int professorId;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String title;
}
