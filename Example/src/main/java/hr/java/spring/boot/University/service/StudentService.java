package hr.java.spring.boot.University.service;

import hr.java.spring.boot.University.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<StudentDto> getStudentList();
    public List<StudentDto> getStudentListByUniversity(String universityName);
    public int addStudentToStudentList(StudentDto studentDto);
    public boolean deleteStudentFromStudentList(int studentId);
    public boolean studentByIdExists(int studentId);
    public Optional<StudentDto> updateStudentById(StudentDto student, int studentId);
}
