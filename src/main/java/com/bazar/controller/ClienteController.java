package com.bazar.controller;

import com.bazar.model.Cliente;
import com.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    // CREAR CLIENTE
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente) {

        clienteService.saveCliente(cliente);

        return "Cliente creado correctamente";
    }

    // TRAER TODOS LOS CLIENTES
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {

        return clienteService.getClientes();
    }

    // TRAER UN CLIENTE
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente) {

        return clienteService.findCliente(id_cliente);
    }

    // ELIMINAR CLIENTE
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {

        clienteService.deleteCliente(id_cliente);

        return "Cliente eliminado correctamente";
    }

    // EDITAR CLIENTE
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente,
                               @RequestBody Cliente cliente) {

        clienteService.editCliente(id_cliente, cliente);

        return clienteService.findCliente(id_cliente);
    }
}