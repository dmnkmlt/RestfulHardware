package hr.java.spring.boot.University.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int studentId;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String dateOfEnrollment;
    private University university;
}
