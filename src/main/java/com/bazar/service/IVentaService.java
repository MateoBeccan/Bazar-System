package com.bazar.service;

import com.bazar.dto.MayorVentaDTO;
import com.bazar.model.Producto;
import com.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    void saveVenta(Venta venta);

    List<Venta> getVentas();

    Venta findVenta(Long codigo_venta);

    void deleteVenta(Long codigo_venta);

    void editVenta(Long codigo_venta, Venta venta);

    List<Producto> getProductosVenta(Long codigo_venta);

    String getResumenVentasPorFecha(LocalDate fecha_venta);

    MayorVentaDTO getMayorVenta();
}