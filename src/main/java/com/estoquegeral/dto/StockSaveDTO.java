package com.estoquegeral.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StockSaveDTO {

    @NotBlank
    private String group;

    @NotBlank
    private String name;


    private String brand;
    private String description;

    @NotNull
    @Min(value = 0, message = "A quantidade não pode ser negativa!")
    private Double quantity;

    @NotEmpty
    private String unit;

    @NotBlank
    private String location;

}