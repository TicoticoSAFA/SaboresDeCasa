package com.example.saboresdecasa;

import com.example.saboresdecasa.dto.PedidoClientesDTO;
import com.example.saboresdecasa.models.*;
import com.example.saboresdecasa.repositorios.MesaRepository;
import com.example.saboresdecasa.servicios.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class PedidoTest {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MesaRepository mesaRepository;

    @BeforeEach
    public void inicializarDatos() {
        Mesa mesa = new Mesa();
        mesa.setNumero(1);
        mesaRepository.save(mesa);

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Perez");
        clienteService.guardar(cliente);

        Pedido pedido1 = new Pedido();
        pedido1.setPrecio(50.00);
        pedido1.setFecha(LocalDate.now());
        pedido1.setMesa(mesa);
        pedido1.setCliente(cliente);
        pedidoService.guardar(pedido1);

        Pedido pedido2 = new Pedido();
        pedido2.setPrecio(30.00);
        pedido2.setFecha(LocalDate.now());
        pedido2.setMesa(mesa);
        pedido2.setCliente(cliente);
        pedidoService.guardar(pedido2);

        Pedido pedido3 = new Pedido();
        pedido3.setPrecio(18.75);
        pedido3.setFecha(LocalDate.now());
        pedido3.setMesa(mesa);
        pedido3.setCliente(cliente);
        pedidoService.guardar(pedido3);
    }

    @Test
    void getClientes(){
        PedidoClientesDTO pedidoClientesDTO = pedidoService.getClientes(1);
        assertEquals(3, pedidoClientesDTO.getPedidos().size());
        assertEquals(98.75, pedidoClientesDTO.getTotal());
    }

    @Test
    void getClientesNoPedidos() {
        PedidoClientesDTO pedidoClientesDTO = pedidoService.getClientes(999); // ID de mesa que no existe
        assertEquals(0, pedidoClientesDTO.getPedidos().size());
        assertEquals(0.0, pedidoClientesDTO.getTotal());
    }
}