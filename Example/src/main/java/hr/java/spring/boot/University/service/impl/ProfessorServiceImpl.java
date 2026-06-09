package hr.java.spring.boot.University.service.impl;

import hr.java.spring.boot.University.domain.Professor;
import hr.java.spring.boot.University.dto.ProfessorDto;
import hr.java.spring.boot.University.repository.ProfessorRepository;
import hr.java.spring.boot.University.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository professorRepository;

    @Override
    public List<ProfessorDto> getProfessorList() {
        return professorRepository.getProfessorList().stream().map(this::professorToProfessorDto).toList();
    };

    @Override
    public int addProfessorToProfessorList(ProfessorDto professorDto) {
        return professorRepository.addProfessorToProfessorList(professorDtoToProfessor(professorDto));
    };

    @Override
    public boolean deleteProfessorFromProfessorList(int professorId) {
        return professorRepository.deleteProfessorFromProfessorList(professorId);
    };

    @Override
    public boolean professorByIdExists(int professorId) {
        return professorRepository.professorByIdExists(professorId);
    };

    @Override
    public Optional<ProfessorDto> updateProfessorById(ProfessorDto professor, int professorId) {
        Optional<Professor> updatedProfessor = professorRepository.updateProfessorById(professorDtoToProfessor(professor), professorId);

        if(updatedProfessor.isPresent()) {
            return Optional.of(professorToProfessorDto(updatedProfessor.get()));
        }

        return Optional.empty();
    };

    public ProfessorDto professorToProfessorDto(Professor professor) {
        return new ProfessorDto(professor.getName(), professor.getSurname(), professor.getDateOfBirth(), professor.getTitle());
    }

    public Professor professorDtoToProfessor(ProfessorDto professorDto) {
        return new Professor(-1, professorDto.getName(), professorDto.getSurname(), professorDto.getDateOfBirth(), professorDto.getTitle());
    }
}
