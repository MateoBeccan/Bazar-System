package com.bazar.controller;

import com.bazar.model.Producto;
import com.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    // CREAR PRODUCTO
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {

        productoService.saveProducto(producto);

        return "Producto creado correctamente";
    }

    // TRAER TODOS LOS PRODUCTOS
    @GetMapping("/productos")
    public List<Producto> getProductos() {

        return productoService.getProductos();
    }

    // TRAER UN PRODUCTO
    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto) {

        return productoService.findProducto(codigo_producto);
    }

    // ELIMINAR PRODUCTO
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {

        productoService.deleteProducto(codigo_producto);

        return "Producto eliminado correctamente";
    }

    // EDITAR PRODUCTO
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
                                 @RequestBody Producto producto) {

        productoService.editProducto(codigo_producto, producto);

        return productoService.findProducto(codigo_producto);
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> getProductosFaltaStock() {
        return productoService.getProductosFaltaStock();
    }
}