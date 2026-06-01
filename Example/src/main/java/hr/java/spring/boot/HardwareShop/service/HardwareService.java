package hr.java.spring.boot.HardwareShop.service;


import hr.java.spring.boot.HardwareShop.dto.HardwareDto;

import java.util.List;

public interface HardwareService {

    List<HardwareDto> getAllHardware();
    List<HardwareDto> getHardwaresByType(String type);
}
