BONUS IMPLEMENTADO

Requerimiento:
Al registrar una venta, el sistema debe validar que los productos vendidos existan y que tengan stock disponible. Si la validación es correcta, el sistema descuenta automáticamente una unidad del stock de cada producto incluido en la venta.

Método HTTP:
POST

Endpoint:
localhost:8080/ventas/crear

Funcionamiento:
Al recibir una venta con una lista de productos, el backend busca cada producto en la base de datos. Si alguno no existe o no posee stock disponible, la venta no se registra. Si todos los productos cumplen la condición, se registra la venta y se actualiza el stock.

Ejemplo:
Si el producto con código 1 tiene cantidad_disponible = 10 y se registra una venta que lo contiene, luego de la operación quedará con cantidad_disponible = 9.
