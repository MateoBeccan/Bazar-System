package com.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {

    @Id
    private Long codigo_producto;

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
}