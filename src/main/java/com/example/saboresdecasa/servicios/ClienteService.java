package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.Cliente;
import com.example.saboresdecasa.repositorios.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    /**
     * ELiminamos un cliente por id
     *
     * @param id
     */
    public void eliminar(Integer id) {
        clienteRepository.deleteById(id);
    }

    /**
     * Obtenemos todos los clientes
     *
     * @return
     */
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    /**
     * Obtenemos un cliente por id
     *
     * @param id
     * @return
     */
    public Cliente getById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    /**
     * guardamos o modificamos un cliente
     *
     * @param cliente
     * @return
     */
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
