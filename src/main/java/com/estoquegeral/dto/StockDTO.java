package com.estoquegeral.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockDTO {
    private long id;
    private String group;
    private String name;
    private String brand;
    private String description;
    private String unit;
    private double quantity;
    private String location;
}
