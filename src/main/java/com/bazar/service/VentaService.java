package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.model.Venta;
import com.bazar.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bazar.dto.MayorVentaDTO;
import java.time.LocalDate;

import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public void saveVenta(Venta venta) {
        ventaRepository.save(venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepository.findById(codigo_venta).orElse(null);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepository.deleteById(codigo_venta);
    }

    @Override
    public void editVenta(Long codigo_venta, Venta venta) {
        Venta ventaEditar = this.findVenta(codigo_venta);

        ventaEditar.setFecha_venta(venta.getFecha_venta());
        ventaEditar.setTotal(venta.getTotal());
        ventaEditar.setListaProductos(venta.getListaProductos());
        ventaEditar.setUnCliente(venta.getUnCliente());

        this.saveVenta(ventaEditar);
    }

    @Override
    public List<Producto> getProductosVenta(Long codigo_venta) {
        Venta venta = this.findVenta(codigo_venta);
        return venta.getListaProductos();
    }

    @Override
    public String getResumenVentasPorFecha(LocalDate fecha_venta) {

        List<Venta> ventasDelDia = this.getVentas().stream()
                .filter(venta -> venta.getFecha_venta().equals(fecha_venta))
                .toList();

        Double montoTotal = ventasDelDia.stream()
                .mapToDouble(Venta::getTotal)
                .sum();

        int cantidadVentas = ventasDelDia.size();

        return "El monto total vendido el día " + fecha_venta +
                " fue de $" + montoTotal +
                " y la cantidad total de ventas fue: " + cantidadVentas;
    }

    @Override
    public MayorVentaDTO getMayorVenta() {

        Venta mayorVenta = this.getVentas().stream()
                .max((v1, v2) -> Double.compare(v1.getTotal(), v2.getTotal()))
                .orElse(null);

        if (mayorVenta == null) {
            return null;
        }

        return new MayorVentaDTO(
                mayorVenta.getCodigo_venta(),
                mayorVenta.getTotal(),
                mayorVenta.getListaProductos().size(),
                mayorVenta.getUnCliente().getNombre(),
                mayorVenta.getUnCliente().getApellido()
        );
    }
}