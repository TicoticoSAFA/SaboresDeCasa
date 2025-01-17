package com.example.saboresdecasa;
import com.example.saboresdecasa.dto.CuentaDTO;
import com.example.saboresdecasa.dto.LineaPedidoDTO;
import com.example.saboresdecasa.dto.LineaPedidoGuardarPedidoDTO;
import com.example.saboresdecasa.dto.PedidoGuardarDTO;
import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.*;
import com.example.saboresdecasa.repositorios.CamareroRepository;
import com.example.saboresdecasa.repositorios.LineaPedidoRepository;
import com.example.saboresdecasa.repositorios.PedidoRepository;
import com.example.saboresdecasa.servicios.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LineaPedidoServiceIntegrationTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private ClienteService clienteService;

    @Mock
    private MesaService mesaService;

    @Mock
    private TipoProductoService tipoProductoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Mock
    private LineaPedidoRepository lineaPedidoRepository;

    @Mock
    private LineaPedidoService lineaPedidoService;

    @BeforeEach
    public void setUp() {
       Camarero camarero1 = new Camarero();
        camarero1.setNombre("Luis");
        camarero1.setApellidos("Pérez Gómez");
        camarero1.setDni("12345678A");
        camarero1.setEmail("luis.perez@ejemplo.com");

        Mesa mesa1 = new Mesa();
        mesa1.setNumero(1);
        mesa1.setCamarero(camarero1);

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Ana García");

        Pedido pedido1 = new Pedido();
        pedido1.setPrecio(45.50);
        pedido1.setFecha(LocalDate.of(2025, 1, 10));
        pedido1.setMesa(mesa1);
        pedido1.setCliente(cliente1);

        Producto producto1 = new Producto();
        producto1.setNombre("Gambas al ajillo");
        producto1.setDescripcion("Gambas al ajillo con guindilla");

        TipoProducto tipoProducto1 = new TipoProducto();
        tipoProducto1.setTipo(TipoTipoProducto.PLATOSDELMARFRITO);
        tipoProducto1.setPrecio(12.50);
        tipoProducto1.setTamanyo(TamanyoTipoProducto.RACION);
        tipoProducto1.setProducto(producto1);

        LineaPedido lineaPedido1 = new LineaPedido();
        lineaPedido1.setCantidad(2);
        lineaPedido1.setTipoProducto(tipoProducto1);
        lineaPedido1.setPedido(pedido1);

        Mockito.when(pedidoService.getById(1)).thenReturn(pedido1);
        Mockito.when(lineaPedidoRepository.findByPedido(pedido1)).thenReturn(List.of(lineaPedido1));
    }

    @Test
    public void cuentaLineaPedido() {
        //GIVEN
        Camarero camarero1 = new Camarero();
        camarero1.setNombre("Luis");
        camarero1.setApellidos("Pérez Gómez");
        camarero1.setDni("12345678A");
        camarero1.setEmail("luis.perez@ejemplo.com");

        Mesa mesa1 = new Mesa();
        mesa1.setNumero(1);
        mesa1.setCamarero(camarero1);

        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Ana García");

        Pedido pedido1 = new Pedido();
        pedido1.setPrecio(45.50);
        pedido1.setFecha(LocalDate.of(2025, 1, 10));
        pedido1.setMesa(mesa1);
        pedido1.setCliente(cliente1);

        Producto producto1 = new Producto();
        producto1.setNombre("Gambas al ajillo");
        producto1.setDescripcion("Gambas al ajillo con guindilla");

        TipoProducto tipoProducto1 = new TipoProducto();
        tipoProducto1.setTipo(TipoTipoProducto.PLATOSDELMARFRITO);
        tipoProducto1.setPrecio(12.50);
        tipoProducto1.setTamanyo(TamanyoTipoProducto.RACION);
        tipoProducto1.setProducto(producto1);

        LineaPedido lineaPedido1 = new LineaPedido();
        lineaPedido1.setCantidad(2);
        lineaPedido1.setTipoProducto(tipoProducto1);
        lineaPedido1.setPedido(pedido1);
        //WHEN
        Mockito.when(pedidoService.getById(1)).thenReturn(pedido1);
        Mockito.when(lineaPedidoRepository.findByPedido(pedido1)).thenReturn(List.of(lineaPedido1));
        CuentaDTO cuentaDTO = lineaPedidoService.getCuenta(1);

        //THEN
        assertEquals(45.50, cuentaDTO.getPedido().getTotal());
    }

    @Test
    public void testCrearPedido_Exito() {
        // Arrange
        PedidoGuardarDTO pedidoGuardarDTO = new PedidoGuardarDTO();
        pedidoGuardarDTO.setIdCliente(1);
        pedidoGuardarDTO.setIdMesa(1);

        LineaPedidoGuardarPedidoDTO lineaDTO = new LineaPedidoGuardarPedidoDTO();
        lineaDTO.setCantidad(2);
        lineaDTO.setIdTipoProducto(1);

        pedidoGuardarDTO.setLineasPedido(List.of(lineaDTO));

        Cliente cliente = new Cliente();
        cliente.setId(1);
        cliente.setNombre("Cliente 1");

        Mesa mesa = new Mesa();
        mesa.setId(1);
        mesa.setNumero(5);

        TipoProducto tipoProducto = new TipoProducto();
        tipoProducto.setId(1);
        tipoProducto.setPrecio(10.0);

        Pedido pedidoGuardado = new Pedido();
        pedidoGuardado.setId(1);

        Mockito.when(clienteService.getById(1)).thenReturn(cliente);
        Mockito.when(mesaService.getById(1)).thenReturn(mesa);
        Mockito.when(tipoProductoService.getById(1)).thenReturn(tipoProducto);
        Mockito.when(pedidoRepository.save(Mockito.any(Pedido.class))).thenReturn(pedidoGuardado);
        Mockito.when(lineaPedidoRepository.save(Mockito.any(LineaPedido.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Pedido resultado = lineaPedidoService.crearPedido(pedidoGuardarDTO);

        // Assert
        assertNotNull(resultado);
        assertEquals(1, resultado.getId());
        Mockito.verify(clienteService).getById(1);
        Mockito.verify(mesaService).getById(1);
        Mockito.verify(tipoProductoService).getById(1);
        Mockito.verify(pedidoRepository).save(Mockito.any(Pedido.class));
        Mockito.verify(lineaPedidoRepository, Mockito.times(1)).save(Mockito.any(LineaPedido.class));
    }
}
