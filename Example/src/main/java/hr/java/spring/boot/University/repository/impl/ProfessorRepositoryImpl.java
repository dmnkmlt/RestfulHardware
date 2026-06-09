package hr.java.spring.boot.University.repository.impl;

import hr.java.spring.boot.University.domain.Professor;
import hr.java.spring.boot.University.repository.ProfessorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProfessorRepositoryImpl implements ProfessorRepository {

    private static List<Professor> professorList = new ArrayList(List.of(
            new Professor(1, "Pero", "Perić", "13/01/1998", "mag.ing."),
            new Professor(2, "Ana", "Anić", "12/05/1981", "dr.sc."),
            new Professor(3, "Bero", "Berić", "13/11/1978", "prof.dr.sc."),
            new Professor(4, "Darko", "Dakić", "13/7/1965", "mr.sc."),
            new Professor(5, "Filip", "Filipović", "13/12/1256", "dr.sc.")
            ));

    @Override
    public List<Professor> getProfessorList() {
        return professorList;
    }

    @Override
    public int addProfessorToProfessorList() {
        return 1;
    }

    @Override
    public boolean deleteProfessorFromProfessorList(int professorId) {
        return professorList.removeIf(professor -> professor.getProfessorId() == professorId);
    }

    public boolean professorByIdExists(int professorId) {
        return professorList.stream().anyMatch(professor -> professor.getProfessorId() == professorId);
    }

    @Override
    public Optional<Professor> updateProfessorById(Professor professor, int professorId) {
        return Optional.empty();
    }

}
