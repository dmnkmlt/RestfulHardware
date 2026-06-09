package hr.java.spring.boot.University.controller;

import hr.java.spring.boot.University.dto.StudentDto;
import hr.java.spring.boot.University.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getStudentList(){
        return studentService.getStudentList();
    }

    @GetMapping("/students/{universityName}")
    public List<StudentDto> getStudentList(@PathVariable String universityName){
        return studentService.getStudentListByUniversity(universityName);
    }

    @DeleteMapping("/students/{studentId}")
    public boolean deleteStudentFromStudentList(@PathVariable int studentId) {
        return studentService.deleteStudentFromStudentList(studentId);
    }
}
