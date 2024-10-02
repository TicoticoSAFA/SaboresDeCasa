package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Cliente;
import com.example.saboresdecasa.servicios.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestCliente {

    @Autowired
    private ClienteService clienteService;

    @Test
    void testFindAll(){
        List<Cliente> clientes = clienteService.getAll();
        for (Cliente i : clientes){
            System.out.println(i.toString());
        }
    }

    @Test
    void testFindById() {
        Cliente cliente = clienteService.getById(10);
        System.out.println(cliente.toString());
    }

    @Test
    void testGuardar() {
        Cliente cliente = new Cliente();
        cliente.setNombre("David Gonzalez Galdós");
        clienteService.guardar(cliente);
    }

    @Test
    void testEditar(){
        Cliente cliente = clienteService.getById(15);
        cliente.setNombre("Gonzalo Huezas Fernandez");
    }

    @Test
    void testElimianr(){
        clienteService.eliminar(9);
    }

}
