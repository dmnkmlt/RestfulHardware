package hr.java.spring.boot.University.service;

import hr.java.spring.boot.University.dto.ProfessorDto;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    public List<ProfessorDto> getProfessorList();
    public int addProfessorToProfessorList(ProfessorDto professorDto);
    public boolean deleteProfessorFromProfessorList(int professorId);
    public boolean professorByIdExists(int professorId);
    public Optional<ProfessorDto> updateProfessorById(ProfessorDto professor, int professorId);
}
