package hr.java.spring.boot.HardwareShop.controller;

import hr.java.spring.boot.HardwareShop.dto.AutoDto;
import hr.java.spring.boot.HardwareShop.service.AutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AutoController {

    private AutoService autoService;

    @GetMapping
    public List<AutoDto> getAllAuto(){
        return autoService.getAllAuto();
    }
}
