package hr.java.spring.boot.HardwareShop.controller;

import hr.java.spring.boot.HardwareShop.dto.HardwareDto;
import hr.java.spring.boot.HardwareShop.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping("/get-all-hardware")
    public List<HardwareDto> getAllHardware(){
        return hardwareService.getAllHardware();
    }

    @GetMapping("/get-hardwares-by-type/{type}")
    public List<HardwareDto> getHardwareSByType(@PathVariable String type){
        return hardwareService.getHardwaresByType(type);
    }
}
