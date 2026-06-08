package hr.java.spring.boot.HardwareShop.service;


import hr.java.spring.boot.HardwareShop.dto.HardwareDto;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDto> getAllHardware();
    List<HardwareDto> getHardwaresByType(String type);
    int saveNewHardware(HardwareDto hardwareDto);
    boolean deleteHardwareById(int id);
    Optional<HardwareDto> updateHardware(HardwareDto hardwareDto, int hardwareId);
    boolean hardwareByIdExists(int hardwareId);
}
