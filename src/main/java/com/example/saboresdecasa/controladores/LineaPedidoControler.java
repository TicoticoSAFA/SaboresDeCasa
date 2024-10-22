package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.CuentaDTO;
import com.example.saboresdecasa.dto.LineaPedidoDTO;
import com.example.saboresdecasa.dto.LineaPedidoGuardarDTO;
import com.example.saboresdecasa.dto.PedidoGuardarDTO;
import com.example.saboresdecasa.models.LineaPedido;
import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.servicios.LineaPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linea_pedido")
@AllArgsConstructor
public class LineaPedidoControler {

    private LineaPedidoService lineaPedidoService;

    @GetMapping("/listar")
    public List<LineaPedidoDTO> getAllLineaPedido(){
        return lineaPedidoService.getAll();
    }

    @GetMapping("/cuenta/{idPedido}")
    public CuentaDTO cuentaLineaPedido(@PathVariable Integer idPedido){
        return lineaPedidoService.getCuenta(idPedido);
    }

    @GetMapping("/pedido")
    public Pedido crearPedido(@RequestBody PedidoGuardarDTO pedidoGuardarDTO){
        return lineaPedidoService.crearPedido(pedidoGuardarDTO);
    }
}
