package com.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MayorVentaDTO {

    private Long codigo_venta;
    private Double total;
    private Integer cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public MayorVentaDTO() {
    }

    public MayorVentaDTO(Long codigo_venta, Double total, Integer cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
}