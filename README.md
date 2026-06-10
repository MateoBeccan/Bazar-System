# API REST - Sistema de Gestión para Bazar

Proyecto final desarrollado durante el curso **“Desarrollo de APIs en Java con Spring Boot”** de TodoCode Academy.

La aplicación consiste en una API REST para la gestión de productos, clientes y ventas de un bazar, permitiendo realizar operaciones CRUD completas mediante Spring Boot, JPA y MySQL.

## Tecnologías utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Postman

## Funcionalidades principales

* CRUD completo de Productos
* CRUD completo de Clientes
* CRUD completo de Ventas
* Consulta de productos con bajo stock
* Obtención de productos por venta
* Resumen de ventas por fecha
* DTO para consulta de mayor venta

## BONUS IMPLEMENTADO

### Validación y actualización automática de stock

Al registrar una venta, el sistema valida que los productos existan y que posean stock disponible. Si la validación es correcta, el stock se actualiza automáticamente descontando una unidad por cada producto vendido.

### Endpoint

POST `/ventas/crear`

### Funcionamiento

* La API recibe una venta con una lista de productos.
* El backend verifica que cada producto exista en la base de datos.
* Se valida que haya stock disponible.
* Si algún producto no existe o no tiene stock, la venta no se registra.
* Si todos los productos son válidos, la venta se guarda y el stock se actualiza automáticamente.

### Ejemplo

Si un producto posee:

```json
{
  "codigo_producto": 1,
  "cantidad_disponible": 10
}
```

y se registra una venta que contiene dicho producto, luego de la operación el stock quedará:

```json
{
  "cantidad_disponible": 9
}
```

