package hr.java.spring.boot.HardwareShop.repository.impl;

import hr.java.spring.boot.HardwareShop.domain.Hardware;
import hr.java.spring.boot.HardwareShop.repository.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static List<Hardware> hardwareList = new ArrayList(List.of(
            new Hardware(1, "RTX4070", 599.99, "GPU"),
            new Hardware(2, "RTX4080", 999.99, "GPU"),
            new Hardware(3, "RYZEN7800X3D", 389.99, "CPU"),
            new Hardware(4, "I7-14700K", 419.99, "CPU")
    ));

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

    @Override
    public int saveNewHardware(Hardware hardware){
        int generatedId = hardwareList.size();
        hardware.setId(generatedId + 1);
        hardwareList.add(hardware);

        return generatedId;
    }

    @Override
    public boolean deleteHardwareById(int id){
        return hardwareList.removeIf(hardware -> hardware.getId() == id);
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardware, int id){
        Optional<Hardware> candidates = hardwareList.stream().filter(hardware1 -> hardware1.getId() == id).findFirst();
        if(candidates.isPresent()) {
            Hardware updatedHardware = candidates.get();

            updatedHardware.setCode(hardware.getCode());
            updatedHardware.setPrice(hardware.getPrice());
            updatedHardware.setType(hardware.getType());

            return Optional.of(updatedHardware);
        }

        return Optional.empty();
    }

    @Override
    public boolean hardwareByIdExists(int hardwareId) {
        return hardwareList.stream().anyMatch(hardware -> hardware.getId() == hardwareId);
    }

}
