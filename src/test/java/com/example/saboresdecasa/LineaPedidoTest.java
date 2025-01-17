package com.example.saboresdecasa;

import com.example.saboresdecasa.dto.CuentaDTO;
import com.example.saboresdecasa.dto.LineaPedidoDTO;
import com.example.saboresdecasa.dto.LineaPedidoGuardarPedidoDTO;
import com.example.saboresdecasa.dto.PedidoGuardarDTO;
import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.*;
import com.example.saboresdecasa.servicios.LineaPedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
public class LineaPedidoTest {

    @Autowired
    private LineaPedidoService lineaPedidoService;

    @BeforeEach
    public void inicializarDatos() {
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

        Camarero camarero2 = new Camarero();
        camarero2.setNombre("Marta");
        camarero2.setApellidos("López Ruiz");
        camarero2.setDni("87654321B");
        camarero2.setEmail("marta.lopez@ejemplo.com");

        Mesa mesa2 = new Mesa();
        mesa2.setNumero(2);
        mesa2.setCamarero(camarero2);

        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Carlos Martínez");

        Pedido pedido2 = new Pedido();
        pedido2.setPrecio(20.00);
        pedido2.setFecha(LocalDate.of(2025, 1, 12));
        pedido2.setMesa(mesa2);
        pedido2.setCliente(cliente2);

        Producto producto2 = new Producto();
        producto2.setNombre("Cerveza artesanal");
        producto2.setDescripcion("Cerveza artesanal de trigo");

        TipoProducto tipoProducto2 = new TipoProducto();
        tipoProducto2.setTipo(TipoTipoProducto.CERVEZAS);
        tipoProducto2.setPrecio(4.00);
        tipoProducto2.setTamanyo(TamanyoTipoProducto.BOTELLIN);
        tipoProducto2.setProducto(producto2);

        LineaPedido lineaPedido2 = new LineaPedido();
        lineaPedido2.setCantidad(5);
        lineaPedido2.setTipoProducto(tipoProducto2);
        lineaPedido2.setPedido(pedido2);

        Camarero camarero3 = new Camarero();
        camarero3.setNombre("Javier");
        camarero3.setApellidos("Sánchez Moreno");
        camarero3.setDni("11223344C");
        camarero3.setEmail("javier.sanchez@ejemplo.com");

        Mesa mesa3 = new Mesa();
        mesa3.setNumero(5);
        mesa3.setCamarero(camarero3);

        Cliente cliente3 = new Cliente();
        cliente3.setNombre("Lucía Fernández");

        Pedido pedido3 = new Pedido();
        pedido3.setPrecio(32.75);
        pedido3.setFecha(LocalDate.of(2025, 1, 13));
        pedido3.setMesa(mesa3);
        pedido3.setCliente(cliente3);

        Producto producto3 = new Producto();
        producto3.setNombre("Tarta de queso");
        producto3.setDescripcion("Tarta de queso con mermelada de frutos rojos");

        TipoProducto tipoProducto3 = new TipoProducto();
        tipoProducto3.setTipo(TipoTipoProducto.POSTRES);
        tipoProducto3.setPrecio(5.50);
        tipoProducto3.setTamanyo(TamanyoTipoProducto.UNIDAD);
        tipoProducto3.setProducto(producto3);

        LineaPedido lineaPedido3 = new LineaPedido();
        lineaPedido3.setCantidad(3);
        lineaPedido3.setTipoProducto(tipoProducto3);
        lineaPedido3.setPedido(pedido3);


        lineaPedidoService.guardar(lineaPedido1);
        lineaPedidoService.guardar(lineaPedido2);
        lineaPedidoService.guardar(lineaPedido3);
    }

    @Test
    void getAllLineasPedido() {
        List<LineaPedidoDTO> lineasPedido = lineaPedidoService.getAll();

        assertEquals(3, lineasPedido.size());
        assertFalse(lineasPedido.isEmpty());
    }

    @Test
    void getLineaPedidoById() {
        LineaPedido lineaPedido = lineaPedidoService.getById(1);

        assertNotNull(lineaPedido);
        assertEquals(2, lineaPedido.getCantidad());
    }

    @Test
    void getLineaPedidoByIdNotFound() {
        LineaPedido lineaPedido = lineaPedidoService.getById(100);

        assertNull(lineaPedido);
    }

    @Test
    void crearPedido() {
        PedidoGuardarDTO pedidoGuardarDTO = new PedidoGuardarDTO();
        pedidoGuardarDTO.setIdCliente(1);
        pedidoGuardarDTO.setIdMesa(1);
        pedidoGuardarDTO.setLineasPedido(new ArrayList<>());

        LineaPedidoGuardarPedidoDTO lineaPedido1 = new LineaPedidoGuardarPedidoDTO();
        lineaPedido1.setIdTipoProducto(1);
        lineaPedido1.setCantidad(2);
        lineaPedido1.setIdProducto(1);

        LineaPedidoGuardarPedidoDTO lineaPedido2 = new LineaPedidoGuardarPedidoDTO();
        lineaPedido2.setIdTipoProducto(2);
        lineaPedido2.setCantidad(5);
        lineaPedido2.setIdProducto(2);

        LineaPedidoGuardarPedidoDTO lineaPedido3 = new LineaPedidoGuardarPedidoDTO();
        lineaPedido3.setIdTipoProducto(3);
        lineaPedido3.setCantidad(3);
        lineaPedido3.setIdProducto(3);

        pedidoGuardarDTO.getLineasPedido().add(lineaPedido1);
        pedidoGuardarDTO.getLineasPedido().add(lineaPedido2);
        pedidoGuardarDTO.getLineasPedido().add(lineaPedido3);

        Pedido pedido = lineaPedidoService.crearPedido(pedidoGuardarDTO);

        assertNotNull(pedido);
        assertEquals(61.5, pedido.getPrecio());
    }

    @Test
    void crearPedidoSinLineasPedido() {
        PedidoGuardarDTO pedidoGuardarDTO = new PedidoGuardarDTO();
        pedidoGuardarDTO.setIdCliente(1);
        pedidoGuardarDTO.setIdMesa(1);
        pedidoGuardarDTO.setLineasPedido(new ArrayList<>());

        Pedido pedido = lineaPedidoService.crearPedido(pedidoGuardarDTO);

        assertNull(pedido);
    }

    @Test
    void cuentaLineaPedido() {
        CuentaDTO cuenta = lineaPedidoService.getCuenta(1);

        assertNotNull(cuenta);
        assertEquals(45.5, cuenta.getPedido().getTotal());
    }

    @Test
    void cuentaLineaPedidoNotFound() {
        CuentaDTO cuenta = lineaPedidoService.getCuenta(100);

        assertNull(cuenta);
    }

    @Test
    void guardarLineaPedido() {
        Camarero camarero4 = new Camarero();
        camarero4.setNombre("Sofía");
        camarero4.setApellidos("González Pérez");
        camarero4.setDni("33445566D");
        camarero4.setEmail("sofia.gonzalez@ejemplo.com");

        Mesa mesa4 = new Mesa();
        mesa4.setNumero(3);
        mesa4.setCamarero(camarero4);

        Cliente cliente4 = new Cliente();
        cliente4.setNombre("Miguel Torres");

        Pedido pedido4 = new Pedido();
        pedido4.setPrecio(28.00);
        pedido4.setFecha(LocalDate.of(2025, 1, 15));
        pedido4.setMesa(mesa4);
        pedido4.setCliente(cliente4);

        Producto producto4 = new Producto();
        producto4.setNombre("Ensalada César");
        producto4.setDescripcion("Ensalada César con pollo y aderezo especial");

        TipoProducto tipoProducto4 = new TipoProducto();
        tipoProducto4.setTipo(TipoTipoProducto.POSTRES);
        tipoProducto4.setPrecio(8.00);
        tipoProducto4.setTamanyo(TamanyoTipoProducto.RACION);
        tipoProducto4.setProducto(producto4);

        LineaPedido lineaPedido4 = new LineaPedido();
        lineaPedido4.setCantidad(1);
        lineaPedido4.setTipoProducto(tipoProducto4);
        lineaPedido4.setPedido(pedido4);

        LineaPedido lineaPedidoGuardada = lineaPedidoService.guardar(lineaPedido4);

        assertNotNull(lineaPedidoGuardada);
        assertEquals(1, lineaPedidoGuardada.getCantidad());
    }
}
