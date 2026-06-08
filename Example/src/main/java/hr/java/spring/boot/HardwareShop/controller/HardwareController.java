package hr.java.spring.boot.HardwareShop.controller;

import hr.java.spring.boot.HardwareShop.dto.HardwareDto;
import hr.java.spring.boot.HardwareShop.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/new")
    public int saveNewHardware(@Valid @RequestBody HardwareDto hardwareDto){
        return hardwareService.saveNewHardware(hardwareDto);
    }

    @DeleteMapping("/hardware/{hardwareId}")
    public boolean deleteHardwareById(@PathVariable int hardwareId){
        return hardwareService.deleteHardwareById(hardwareId);
    }

    @PutMapping("/hardware/{hardwareId}")
    public ResponseEntity<?> updateHardware(@Valid @RequestBody HardwareDto hardwareDto, @PathVariable int hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            hardwareService.updateHardware(hardwareDto, hardwareId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
