package hr.java.spring.boot.University.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    private String surname;

    @NotBlank(message = "Date of birth cannot be blank")
    private String dateOfBirth;

    @NotBlank(message = "Date of enrollment cannot be blank")
    private String dateOfEnrollment;

    @NotBlank(message = "University cannot be blank")
    private String university;
}
