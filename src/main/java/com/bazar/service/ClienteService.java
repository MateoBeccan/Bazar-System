package com.bazar.service;

import com.bazar.model.Cliente;
import com.bazar.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findCliente(Long id_cliente) {
        return clienteRepository.findById(id_cliente).orElse(null);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepository.deleteById(id_cliente);
    }

    @Override
    public void editCliente(Long id_cliente, Cliente cliente) {
        Cliente clienteEditar = this.findCliente(id_cliente);

        clienteEditar.setNombre(cliente.getNombre());
        clienteEditar.setApellido(cliente.getApellido());
        clienteEditar.setDni(cliente.getDni());

        this.saveCliente(clienteEditar);
    }
}