package hr.java.spring.boot.HardwareShop.service.impl;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import hr.java.spring.boot.HardwareShop.dto.HardwareDto;
import hr.java.spring.boot.HardwareShop.repository.HardwareRepository;
import hr.java.spring.boot.HardwareShop.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return hardwares.stream()
                .map(h -> new HardwareDto(
                        h.getCode(),
                        h.getPrice(),
                        h.getType()
                ))
                .toList();
    }

    private HardwareDto toDto(Hardware hardware) {
        return new HardwareDto(hardware.getCode(), hardware.getPrice(), hardware.getType());
    }

    private Hardware fromDto(HardwareDto hardwareDto) {
        return new Hardware(-1, hardwareDto.getCode(), hardwareDto.getPrice(), hardwareDto.getType());
    }

    @Override
    public int saveNewHardware(HardwareDto hardwareDto){
        return hardwareRepository.saveNewHardware(fromDto(hardwareDto));
    }

    @Override
    public boolean deleteHardwareById(int id){
        return hardwareRepository.deleteHardwareById(id);
    }

    @Override
    public Optional<HardwareDto> updateHardware(HardwareDto hardwareDto, int hardwareId) {
        Optional<Hardware> updatedHardware = hardwareRepository.updateHardware(fromDto(hardwareDto), hardwareId);

        if (updatedHardware.isPresent()) {
            return Optional.of(toDto(updatedHardware.get()));
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(int hardwareId) {
        return hardwareRepository.hardwareByIdExists(hardwareId);
    }
}
