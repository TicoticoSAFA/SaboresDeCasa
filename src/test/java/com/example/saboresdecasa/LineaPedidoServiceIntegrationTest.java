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
import java.util.ArrayList;
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

//    @BeforeEach
//    public void setUp() {
//       Camarero camarero1 = new Camarero();
//        camarero1.setNombre("Luis");
//        camarero1.setApellidos("Pérez Gómez");
//        camarero1.setDni("12345678A");
//        camarero1.setEmail("luis.perez@ejemplo.com");
//
//        Mesa mesa1 = new Mesa();
//        mesa1.setNumero(1);
//        mesa1.setCamarero(camarero1);
//
//        Cliente cliente1 = new Cliente();
//        cliente1.setNombre("Ana García");
//
//        Pedido pedido1 = new Pedido();
//        pedido1.setPrecio(45.50);
//        pedido1.setFecha(LocalDate.of(2025, 1, 10));
//        pedido1.setMesa(mesa1);
//        pedido1.setCliente(cliente1);
//
//        Producto producto1 = new Producto();
//        producto1.setNombre("Gambas al ajillo");
//        producto1.setDescripcion("Gambas al ajillo con guindilla");
//
//        TipoProducto tipoProducto1 = new TipoProducto();
//        tipoProducto1.setTipo(TipoTipoProducto.PLATOSDELMARFRITO);
//        tipoProducto1.setPrecio(12.50);
//        tipoProducto1.setTamanyo(TamanyoTipoProducto.RACION);
//        tipoProducto1.setProducto(producto1);
//
//        LineaPedido lineaPedido1 = new LineaPedido();
//        lineaPedido1.setCantidad(2);
//        lineaPedido1.setTipoProducto(tipoProducto1);
//        lineaPedido1.setPedido(pedido1);
//
//        Mockito.when(pedidoService.getById(1)).thenReturn(pedido1);
//        Mockito.when(lineaPedidoRepository.findByPedido(pedido1)).thenReturn(List.of(lineaPedido1));
//    }

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
        Camarero camarero1 = new Camarero();
        camarero1.setId(1);
        camarero1.setNombre("Luis");
        camarero1.setApellidos("Pérez Gómez");
        camarero1.setDni("12345678A");
        camarero1.setEmail("luis.perez@ejemplo.com");

        Mesa mesa1 = new Mesa();
        mesa1.setId(1);
        mesa1.setNumero(1);
        mesa1.setCamarero(camarero1);

        Cliente cliente1 = new Cliente();
        cliente1.setId(1);
        cliente1.setNombre("Ana García");

        Pedido pedido1 = new Pedido();
        pedido1.setId(1);
        pedido1.setPrecio(45.50);
        pedido1.setFecha(LocalDate.of(2025, 1, 10));
        pedido1.setMesa(mesa1);
        pedido1.setCliente(cliente1);

        Producto producto1 = new Producto();
        producto1.setId(1);
        producto1.setNombre("Gambas al ajillo");
        producto1.setDescripcion("Gambas al ajillo con guindilla");

        TipoProducto tipoProducto1 = new TipoProducto();
        tipoProducto1.setId(1);
        tipoProducto1.setTipo(TipoTipoProducto.PLATOSDELMARFRITO);
        tipoProducto1.setPrecio(12.50);
        tipoProducto1.setTamanyo(TamanyoTipoProducto.RACION);
        tipoProducto1.setProducto(producto1);

        LineaPedido lineaPedido1 = new LineaPedido();
        lineaPedido1.setId(1);
        lineaPedido1.setCantidad(2);
        lineaPedido1.setTipoProducto(tipoProducto1);
        lineaPedido1.setPedido(pedido1);

        LineaPedidoGuardarPedidoDTO lineaPedidoDTO1 = new LineaPedidoGuardarPedidoDTO(1, 1, 1, 2);

        Mockito.when(clienteService.getById(1)).thenReturn(cliente1);
        Mockito.when(mesaService.getById(1)).thenReturn(mesa1);
        Mockito.when(tipoProductoService.getById(1)).thenReturn(tipoProducto1);
        Mockito.when(pedidoRepository.save(Mockito.any(Pedido.class))).thenReturn(pedido1);

        PedidoGuardarDTO pedidoGuardarDTO = new PedidoGuardarDTO(1, 1, List.of(lineaPedidoDTO1));

        assertEquals(pedido1, lineaPedidoService.crearPedido(pedidoGuardarDTO));
    }
}
