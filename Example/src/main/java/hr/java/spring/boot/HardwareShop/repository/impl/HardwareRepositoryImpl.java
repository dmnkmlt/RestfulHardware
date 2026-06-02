package hr.java.spring.boot.HardwareShop.repository.impl;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import hr.java.spring.boot.HardwareShop.repository.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static final List<Hardware> hardwareList = List.of(
            new Hardware(1, "RTX4070", 599.99, "GPU"),
            new Hardware(2, "RTX4080", 999.99, "GPU"),
            new Hardware(3, "RYZEN7800X3D", 389.99, "CPU"),
            new Hardware(4, "I7-14700K", 419.99, "CPU")
    );

    @Override
    public List<Hardware> getAllHardware() {
        // return List.of();
        return hardwareList;
    }

    @Override
    public List<Hardware> getHardwareByType(String type) {
        // return List.of();
        return hardwareList.stream()
                .filter(h -> type.equalsIgnoreCase(h.getType()))
                .toList();
    }

}
