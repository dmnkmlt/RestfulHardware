package hr.java.spring.boot.HardwareShop.service.impl;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import hr.java.spring.boot.HardwareShop.dto.HardwareDto;
import hr.java.spring.boot.HardwareShop.repository.HardwareRepository;
import hr.java.spring.boot.HardwareShop.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDto> getAllHardware() {
        List<Hardware> hardwares = hardwareRepository.getAllHardware();
        return toDto(hardwares);
    }

    @Override
    public List<HardwareDto> getHardwaresByType(String type) {
        List<Hardware> hardwares = hardwareRepository.getHardwareByType(type);
        List<HardwareDto> hardwareDtos = toDto(hardwares);

        return hardwareDtos;
    }

    private List<HardwareDto> toDto(List<Hardware> hardwares) {
        return List.of();
    }
}
