package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.models.Cliente;
import com.example.saboresdecasa.models.Mesa;
import com.example.saboresdecasa.servicios.CamareroService;
import com.example.saboresdecasa.servicios.ClienteService;
import com.example.saboresdecasa.servicios.MesaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class MesaTest {

    @Autowired
    private MesaService mesaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CamareroService camareroService;

    @Test
    void testFindAll(){
        List<Mesa> mesas = mesaService.getAll();
        for (Mesa i : mesas){
            System.out.println(i.toString());
        }
    }

    @Test
    void test1Mesa(){
        System.out.println(mesaService.getbyId(13));
    }

    @Test
    void testGuardarMesa(){
        Mesa mesa = new Mesa();
        mesa.setId(15);
        mesa.setNumero(15);
        mesa.setCamarero(camareroService.getById(15));
        Set<Cliente> clientes = new HashSet<>();
        clientes.add(clienteService.getById(15));
        clientes.add(clienteService.getById(14));
        mesa.setClientes(clientes);
        Mesa mesaGuardada = mesaService.guardar(mesa);
        System.out.println(mesaGuardada);
    }

    @Test
    void testEditarMesa(){
        Mesa mesa = mesaService.getbyId(15);
        mesa.setNumero(15);
        mesa.setCamarero(camareroService.getById(15));
        Set<Cliente> clientes = new HashSet<>();
        clientes.add(clienteService.getById(15));
        clientes.add(clienteService.getById(14));
        mesa.setClientes(clientes);
        Mesa mesaGuardada = mesaService.guardar(mesa);
        System.out.println(mesaGuardada);
    }

    @Test
    void testEliminar(){
        mesaService.eliminar(15);
    }

}
