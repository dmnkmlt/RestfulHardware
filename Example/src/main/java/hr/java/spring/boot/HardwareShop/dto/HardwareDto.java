package hr.java.spring.boot.HardwareShop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HardwareDto {

    @NotBlank(message = "Hardware code cannot be blank")
    private String code;

    @PositiveOrZero(message = "Price must be R+")
    private double price;

    @NotBlank(message = "Hardware type cannot be blank")
    private String type;
}
