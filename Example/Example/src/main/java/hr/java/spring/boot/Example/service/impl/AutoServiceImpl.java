package hr.java.spring.boot.HardwareShop.service.impl;

import hr.java.spring.boot.HardwareShop.domain.Auto;
import hr.java.spring.boot.HardwareShop.dto.AutoDto;
import hr.java.spring.boot.HardwareShop.repository.AutoRepository;
import hr.java.spring.boot.HardwareShop.service.AutoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AutoServiceImpl implements AutoService {

    private AutoRepository autoRepository;

    @Override
    public List<AutoDto> getAllAuto() {
        List<Auto> auti = autoRepository.getAllAuto();
        return toDto(auti);
    }

    private List<AutoDto> toDto(List<Auto> auti) {
        return List.of();
    }
}
