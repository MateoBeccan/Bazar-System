package com.bazar.service;

import com.bazar.model.Producto;
import java.util.List;

public interface IProductoService {

    void saveProducto(Producto producto);

    List<Producto> getProductos();

    Producto findProducto(Long codigo_producto);

    void deleteProducto(Long codigo_producto);

    void editProducto(Long codigo_producto, Producto producto);

    List<Producto> getProductosFaltaStock();
}