package hr.java.spring.boot.HardwareShop.repository;

import hr.java.spring.boot.HardwareShop.domain.Hardware;

import java.util.List;

public interface HardwareRepository {

    List<Hardware> getAllHardware();
    List<Hardware> getHardwareByType(String type);
}
