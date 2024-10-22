package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.PedidoClientesDTO;
import com.example.saboresdecasa.dto.PedidoDTO;
import com.example.saboresdecasa.dto.PedidoGuardarDTO;
import com.example.saboresdecasa.models.LineaPedido;
import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.servicios.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoControler {

    private PedidoService pedidoService;

    @GetMapping("/listar")
    public List<Pedido> getAllPedidos(){
        return pedidoService.getAll();
    }

    @PostMapping("/pedido")
    public Pedido save(@RequestBody Pedido pedido){
        return pedidoService.guardar(pedido);
    }

    @GetMapping("/pedidos/clientes/{idCliente}")
    public PedidoClientesDTO getPedidosByCliente(@PathVariable Integer idCliente){
        return pedidoService.getClientes(idCliente);
    }

}
