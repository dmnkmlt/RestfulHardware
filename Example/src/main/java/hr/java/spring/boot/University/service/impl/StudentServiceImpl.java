package hr.java.spring.boot.University.service.impl;

import hr.java.spring.boot.University.domain.Student;
import hr.java.spring.boot.University.domain.University;
import hr.java.spring.boot.University.dto.StudentDto;
import hr.java.spring.boot.University.repository.StudentRepository;
import hr.java.spring.boot.University.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> getStudentList() {
        return studentRepository.getStudentList().stream().map(this::studentToStudentDto).toList();
    };

    @Override
    public List<StudentDto> getStudentListByUniversity(String universityName) {
        return studentRepository.getStudentListByUniversity(universityName).stream().map(this::studentToStudentDto).toList();
    };

    @Override
    public int addStudentToStudentList(StudentDto studentDto) {
        return studentRepository.addStudentToStudentList(studentDtoToStudent(studentDto));
    };

    @Override
    public boolean deleteStudentFromStudentList(int studentId) {
        return studentRepository.deleteStudentFromStudentList(studentId);
    };

    @Override
    public boolean studentByIdExists(int studentId) {
        return studentRepository.studentByIdExists(studentId);
    };

    @Override
    public Optional<StudentDto> updateStudentById(StudentDto student, int studentId) {
        Optional<Student> updatedStudent = studentRepository.updateStudentById(studentDtoToStudent(student), studentId);

        if(updatedStudent.isPresent()) {
            return Optional.of(studentToStudentDto(updatedStudent.get()));
        }

        return Optional.empty();
    };

    public StudentDto studentToStudentDto(Student student) {
        return new StudentDto(student.getName(), student.getSurname(), student.getDateOfBirth(), student.getDateOfEnrollment(), student.getUniversity().getFullName());
    }

    public Student studentDtoToStudent(StudentDto studentDto) {
        return new Student(-1, studentDto.getName(), studentDto.getSurname(), studentDto.getDateOfBirth(), studentDto.getDateOfEnrollment(), University.fromFullName(studentDto.getUniversity()));
    }

}
