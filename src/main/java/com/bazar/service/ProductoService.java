package com.bazar.service;

import com.bazar.model.Producto;
import com.bazar.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productoRepository.findById(codigo_producto).orElse(null);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepository.deleteById(codigo_producto);
    }

    @Override
    public void editProducto(Long codigo_producto, Producto producto) {
        Producto productoEditar = this.findProducto(codigo_producto);

        productoEditar.setNombre(producto.getNombre());
        productoEditar.setMarca(producto.getMarca());
        productoEditar.setCosto(producto.getCosto());
        productoEditar.setCantidad_disponible(producto.getCantidad_disponible());

        this.saveProducto(productoEditar);
    }

    @Override
    public List<Producto> getProductosFaltaStock() {
        List<Producto> listaProductos = this.getProductos();

        return listaProductos.stream()
                .filter(producto -> producto.getCantidad_disponible() < 5)
                .toList();
    }
}