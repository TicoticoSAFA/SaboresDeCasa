package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.CuentaDTO;
import com.example.saboresdecasa.dto.LineaPedidoDTO;
import com.example.saboresdecasa.dto.LineaPedidoGuardarDTO;
import com.example.saboresdecasa.models.LineaPedido;
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

//    @PostMapping("id/{idPedido}/{idTipoProducto}")
//    public LineaPedido save(@RequestBody LineaPedidoGuardarDTO lineaPedido, @PathVariable Integer idTipoProducto, @PathVariable Integer idPedido) {
//        return lineaPedidoService.guardar(lineaPedido, idTipoProducto, idPedido);
//    }
}
