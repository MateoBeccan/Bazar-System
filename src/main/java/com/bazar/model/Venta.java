package com.bazar.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Venta {

    @Id
    private Long codigo_venta;

    private LocalDate fecha_venta;

    private Double total;

    @ManyToMany
    private List<Producto> listaProductos;

    @ManyToOne
    private Cliente unCliente;
}