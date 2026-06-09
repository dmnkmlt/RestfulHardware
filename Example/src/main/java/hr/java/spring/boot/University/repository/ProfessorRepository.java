package hr.java.spring.boot.University.repository;

import hr.java.spring.boot.University.domain.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {

    public List<Professor> getProfessorList();
    public int addProfessorToProfessorList(Professor professor);
    public boolean deleteProfessorFromProfessorList(int professorId);
    public boolean professorByIdExists(int professorId);
    public Optional<Professor> updateProfessorById(Professor professor, int professorId);
}
