package hr.java.spring.boot.University.repository;

import hr.java.spring.boot.University.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    public List<Student> getStudentList();
    public List<Student> getStudentListByUniversity(String universityName);
    public int addStudentToStudentList();
    public boolean deleteStudentFromStudentList(int studentId);
    public boolean studentByIdExists(int studentId);
    public Optional<Student> updateStudentById(Student student, int studentId);
}
