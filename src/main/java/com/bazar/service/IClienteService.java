package com.bazar.service;

import com.bazar.model.Cliente;
import java.util.List;

public interface IClienteService {

    void saveCliente(Cliente cliente);

    List<Cliente> getClientes();

    Cliente findCliente(Long id_cliente);

    void deleteCliente(Long id_cliente);

    void editCliente(Long id_cliente, Cliente cliente);
}