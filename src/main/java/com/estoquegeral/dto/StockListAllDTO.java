package com.estoquegeral.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StockListAllDTO {

    private Long id;
    private String group;
    private String name;
    private String brand;
    private String description;
    private Double quantity;
    private String unit;
    private String location;

}
