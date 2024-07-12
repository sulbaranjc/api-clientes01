package com.example.api_clientes01.service.impl;

import com.example.api_clientes01.dao.ClienteDAO;
import com.example.api_clientes01.model.Cliente;
import com.example.api_clientes01.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<Cliente> getClienteById(Long id) {
        return clienteDAO.findById(id);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Optional<Cliente> cliente = clienteDAO.findById(id);
        if (cliente.isPresent()) {
            Cliente clienteToUpdate = cliente.get();
            clienteToUpdate.setNombre(clienteDetails.getNombre());
            clienteToUpdate.setApellido(clienteDetails.getApellido());
            clienteToUpdate.setTelefono(clienteDetails.getTelefono());
            clienteToUpdate.setCorreo(clienteDetails.getCorreo());
            clienteToUpdate.setDireccion(clienteDetails.getDireccion());
            clienteToUpdate.setPais(clienteDetails.getPais());
            return clienteDAO.save(clienteToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCliente(Long id) {
        clienteDAO.deleteById(id);
    }
}
