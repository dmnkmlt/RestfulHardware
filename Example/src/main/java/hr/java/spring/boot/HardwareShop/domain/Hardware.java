package hr.java.spring.boot.HardwareShop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {

    private int id;
    private String code;
    private double price;
    private String type;
}
