package hr.java.spring.boot.University.repository.impl;

import hr.java.spring.boot.University.domain.Student;
import hr.java.spring.boot.University.domain.University;
import hr.java.spring.boot.University.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Hrvoje", "Hrvić", "14/01/2000","24/06/2026", University.ALU),
            new Student(2, "Ivan", "Ivić", "16/02/2001","23/07/2025", University.ALU),
            new Student(3, "Luka", "Lukić", "22/03/2002","22/08/2024", University.GEOF),
            new Student(4, "Marko", "Markić", "21/04/2003","21/11/2023", University.PMF),
            new Student(5, "Tomo", "Tomić", "27/05/2004","11/10/2022", University.PMF)
    ));

    @Override
    public List<Student> getStudentList() {
        return studentList;
    };

    @Override
    public List<Student> getStudentListByUniversity(String universityName) {
        return studentList.stream().filter(student -> student.getUniversity().getFullName().equalsIgnoreCase(universityName)).toList();
    };

    @Override
    public int addStudentToStudentList() {
        return 1;
    };

    @Override
    public boolean deleteStudentFromStudentList(int studentId) {
        return studentList.removeIf(student -> student.getStudentId() == studentId);
    };

    @Override
    public boolean studentByIdExists(int studentId) {
        return studentList.stream().anyMatch(student -> student.getStudentId() == studentId);
    };

    @Override
    public Optional<Student> updateStudentById(Student student, int studentId) {
        return Optional.empty();
    };
}
