package com.bazar.controller;

import com.bazar.dto.MayorVentaDTO;
import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    // CREAR VENTA
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta) {

        ventaService.saveVenta(venta);

        return "Venta creada correctamente";
    }

    // TRAER TODAS LAS VENTAS
    @GetMapping("/ventas")
    public List<Venta> getVentas() {

        return ventaService.getVentas();
    }

    // TRAER UNA VENTA
    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta) {

        return ventaService.findVenta(codigo_venta);
    }

    // ELIMINAR VENTA
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {

        ventaService.deleteVenta(codigo_venta);

        return "Venta eliminada correctamente";
    }

    // EDITAR VENTA
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVenta(@PathVariable Long codigo_venta,
                           @RequestBody Venta venta) {

        ventaService.editVenta(codigo_venta, venta);

        return ventaService.findVenta(codigo_venta);
    }

    // PRODUCTOS DE UNA VENTA
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosVenta(@PathVariable Long codigo_venta) {

        return ventaService.getProductosVenta(codigo_venta);
    }

    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String getResumenVentasPorFecha(@PathVariable LocalDate fecha_venta) {
        return ventaService.getResumenVentasPorFecha(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public MayorVentaDTO getMayorVenta() {
        return ventaService.getMayorVenta();
    }
}