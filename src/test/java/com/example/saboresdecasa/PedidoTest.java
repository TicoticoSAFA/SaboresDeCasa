package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.servicios.MesaService;
import com.example.saboresdecasa.servicios.PedidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PedidoTest {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private MesaService mesaService;

    @Test
    void testFindAll(){
        List<Pedido> pedidos = pedidoService.getAll();
        for (Pedido i : pedidos){
            System.out.println(i.toString());
        }
    }

    @Test
    void testFindById() {
        Pedido pedido = pedidoService.getById(25);
        System.out.println(pedido.toString());
    }

//    @Test
//    void testSave() {
//        Pedido pedido = new Pedido();
//        pedido.setId(9);
//        pedido.setPrecio(100.0);
//        pedido.setFecha(LocalDate.of(2021,5,14));
//        pedido.setMesa(mesaService.getbyId(14));
//        Pedido pedidoGuardado = pedidoService.guardar(pedido);
//        System.out.println(pedidoGuardado);
//    }

    @Test
    void testEdit() {
        Pedido pedido = pedidoService.getById(25);
        pedido.setPrecio(150.0);
        Pedido pedidoGuardado = pedidoService.guardar(pedido);
        System.out.println(pedidoGuardado);
    }
}
