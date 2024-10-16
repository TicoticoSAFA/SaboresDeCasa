package com.example.saboresdecasa.controladores;

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

    @PostMapping("/pedido/{idPedido}/{idMesa}")
    public Pedido save(@RequestBody PedidoGuardarDTO pedidoGuardarDTO, @PathVariable Integer idPedido, @PathVariable Integer idMesa){
        return pedidoService.guardar(pedidoGuardarDTO, idPedido, idMesa);
    }

}
