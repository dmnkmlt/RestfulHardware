package hr.java.spring.boot.HardwareShop.repository.impl;

import hr.java.spring.boot.HardwareShop.domain.Auto;
import hr.java.spring.boot.HardwareShop.repository.AutoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutoRepositoryImpl implements AutoRepository {


    @Override
    public List<Auto> getAllAuto() {
        return List.of();
    }
}
