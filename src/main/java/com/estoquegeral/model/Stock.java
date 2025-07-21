package com.estoquegeral.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "`group`") //Evita conlfito com SQL "group"
    private String group;
    private String name;

    @Column(name = "brand", nullable = true, columnDefinition = "VARCHAR(100) DEFAULT 'Genérico(a)'")
    private String brand;

    private String description;
    private Double quantity;
    private String unit;
    private String location;

}


