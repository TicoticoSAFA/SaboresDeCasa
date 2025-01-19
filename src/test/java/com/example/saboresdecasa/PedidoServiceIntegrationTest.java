package com.example.saboresdecasa;

import com.example.saboresdecasa.dto.MesaPedidoDTO;
import com.example.saboresdecasa.dto.PedidoClientesDTO;
import com.example.saboresdecasa.dto.PedidoDTO;
import com.example.saboresdecasa.models.Cliente;
import com.example.saboresdecasa.models.Mesa;
import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.repositorios.PedidoRepository;
import com.example.saboresdecasa.servicios.ClienteService;
import com.example.saboresdecasa.servicios.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceIntegrationTest {
    @InjectMocks
    private PedidoService pedidoService;
    @Mock
    private PedidoService pedidoServiceMock;
    @Mock
    private ClienteService clienteService;
    @Mock
    private PedidoRepository pedidoRepository;


    @Test
    public void getClientes() {
        Mesa mesa = new Mesa();
        mesa.setNumero(1);

        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Perez");

        Pedido pedido1 = new Pedido();
        pedido1.setPrecio(50.00);
        pedido1.setFecha(LocalDate.now());
        pedido1.setMesa(mesa);
        pedido1.setCliente(cliente);

        Pedido pedido2 = new Pedido();
        pedido2.setPrecio(30.00);
        pedido2.setFecha(LocalDate.now());
        pedido2.setMesa(mesa);
        pedido2.setCliente(cliente);

        Pedido pedido3 = new Pedido();
        pedido3.setPrecio(18.75);
        pedido3.setFecha(LocalDate.now());
        pedido3.setMesa(mesa);
        pedido3.setCliente(cliente);

        PedidoClientesDTO pedidoClientesDTO = new PedidoClientesDTO();
        pedidoClientesDTO.setPedidos(List.of(
                new PedidoDTO(pedido1.getPrecio(), pedido1.getFecha().toString(), new MesaPedidoDTO(pedido1.getMesa().getNumero())),
                new PedidoDTO(pedido2.getPrecio(), pedido2.getFecha().toString(), new MesaPedidoDTO(pedido2.getMesa().getNumero())),
                new PedidoDTO(pedido3.getPrecio(), pedido3.getFecha().toString(), new MesaPedidoDTO(pedido3.getMesa().getNumero()))
        ));
        pedidoClientesDTO.setTotal(pedido1.getPrecio() + pedido2.getPrecio() + pedido3.getPrecio());

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);

        Mockito.when(pedidoRepository.findAllByClienteEquals(cliente)).thenReturn(pedidos);
        Mockito.when(clienteService.getById(1)).thenReturn(cliente);

        PedidoClientesDTO pedidoClientesDTOTest = pedidoService.getClientes(1);
        assertEquals(98.75, pedidoClientesDTOTest.getTotal());
        assertEquals(3, pedidoClientesDTOTest.getPedidos().size());
    }
}
