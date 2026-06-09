package hr.java.spring.boot.University.controller;

import hr.java.spring.boot.University.dto.StudentDto;
import hr.java.spring.boot.University.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/students")
    public int addStudentToStudentList(@Valid @RequestBody StudentDto studentDto) {
        return studentService.addStudentToStudentList(studentDto);
    }

    @PutMapping("/students/{studentId}")
    public ResponseEntity<?> updateStudentById(@Valid @RequestBody StudentDto studentDto, @PathVariable int studentId) {
        if(studentService.studentByIdExists(studentId)) {
            return ResponseEntity.ok(studentService.updateStudentById(studentDto, studentId));
        }

        return ResponseEntity.notFound().build();
    }
}
