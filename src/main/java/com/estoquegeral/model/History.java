package com.estoquegeral.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // ENTRADA ou SAIDA
    private Long stockId;
    private String group;
    private String name;
    private String brand;
    private double quantity;
    private String unit;
    private String location;
    private String destino;
    private String retirante;
    private String destinatario;
    private LocalDateTime dataHora;
}
