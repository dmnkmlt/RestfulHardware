package hr.java.spring.boot.HardwareShop.repository.impl;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import hr.java.spring.boot.HardwareShop.repository.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {


    @Override
    public List<Hardware> getAllHardware() {
        return List.of();
    }

    @Override
    public List<Hardware> getHardwareByType(String type) {
        return List.of();
    }

}
