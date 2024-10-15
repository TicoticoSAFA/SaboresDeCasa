//package com.example.saboresdecasa;
//
//import com.example.saboresdecasa.models.LineaPedido;
//import com.example.saboresdecasa.servicios.LineaPedidoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class LineaPedidoTest {
//
//    @Autowired
//    private LineaPedidoService lineaPedidoService;
//
//    @Test
//    void getAll(){
//        List<LineaPedido> lineaPedidoList = lineaPedidoService.getAll();
//        for (LineaPedido i : lineaPedidoList){
//            System.out.println(i.toString());
//        }
//    }
//
//    @Test
//    void getById(){
//        LineaPedido lineaPedido = lineaPedidoService.getById(1);
//        System.out.println(lineaPedido.toString());
//    }
//
//    @Test
//    void guardar(){
//        LineaPedido lineaPedido = new LineaPedido();
//        lineaPedido.setPedido(lineaPedidoService.getById(1).getPedido());
//        lineaPedido.setProducto(lineaPedidoService.getById(1).getProducto());
//        lineaPedido.setTipoProducto(lineaPedidoService.getById(1).getTipoProducto());
//        lineaPedido.setCantidad(2);
//        lineaPedidoService.guardar(lineaPedido);
//    }
//
//    @Test
//    void modificar(){
//        LineaPedido lineaPedido = lineaPedidoService.getById(11);
//        lineaPedido.setCantidad(3);
//        lineaPedidoService.guardar(lineaPedido);
//    }
//
//    @Test
//    void eliminar(){
//        lineaPedidoService.eliminar(11);
//    }
//}
