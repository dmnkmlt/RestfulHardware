package hr.java.spring.boot.University.controller;

import hr.java.spring.boot.University.dto.ProfessorDto;
import hr.java.spring.boot.University.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProfessorController {

    private ProfessorService professorService;

    @GetMapping("/professors")
    public List<ProfessorDto> getProfessorList(){
        return professorService.getProfessorList();
    }

    @DeleteMapping("/professors/{professorId}")
    public boolean deleteProfessorFromProfessorList(@PathVariable int professorId) {
        return professorService.deleteProfessorFromProfessorList(professorId);
    }

    @PostMapping("/professors")
    public int addProfessorToProfessorList(@Valid @RequestBody ProfessorDto professorDto) {
        return professorService.addProfessorToProfessorList(professorDto);
    }
}
