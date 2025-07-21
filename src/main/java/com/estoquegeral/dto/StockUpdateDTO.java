package com.estoquegeral.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StockUpdateDTO {

    private Long id;
    private String group;
    private String name;
    private String brand;
    private String description;

    @Min(value = 0, message = "A quantidade não pode ser negativa!")
    private Double quantity;
    private String unit;
    private String location;

}
