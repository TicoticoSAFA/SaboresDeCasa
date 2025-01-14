package com.example.saboresdecasa;

import com.example.saboresdecasa.dto.LineaPedidoDTO;
import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.*;
import com.example.saboresdecasa.servicios.LineaPedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
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
}
