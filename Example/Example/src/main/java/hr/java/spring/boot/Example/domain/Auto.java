package hr.java.spring.boot.HardwareShop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Auto {

    private int id;
    private String boja;
    private int snaga;
}
