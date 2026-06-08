package hr.java.spring.boot.HardwareShop.repository;

import hr.java.spring.boot.HardwareShop.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByType(String type);
    int saveNewHardware(Hardware hardware);
    boolean deleteHardwareById(int id);
    Optional<Hardware> updateHardware(Hardware hardware, int id);
    boolean hardwareByIdExists(int hardwareId);
}
