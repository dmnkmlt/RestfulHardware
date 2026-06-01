package hr.java.spring.boot.HardwareShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HardwareDto {

    private String code;
    private double price;
    private String type;
}
