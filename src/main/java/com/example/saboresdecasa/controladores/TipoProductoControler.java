package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.TipoProductoDTO;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.servicios.TipoProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipo_producto")
@AllArgsConstructor
public class TipoProductoControler {

    private TipoProductoService tipoProductoService;

    // GetMapping para listar todos los tipos de productos
    @GetMapping("/carta")
    public List<TipoProductoDTO> getAllTipoProducto(){
        return tipoProductoService.getAll();
    }

    @GetMapping()
    public TipoProducto getByIdTipoProducto(@RequestParam  Integer id){
        return tipoProductoService.getById(id);
    }

    @GetMapping("/productoformato/{tipoTipoProducto}")
    public List<TipoProducto> getByIdTipoProducto(@PathVariable String tipoTipoProducto){
        return tipoProductoService.getAllByTipo(TipoTipoProducto.valueOf(tipoTipoProducto));
    }

    @PostMapping("id/{idTipoProducto}/{idProducto}")
    public TipoProducto save(@RequestBody TipoProductoDTO tipoProducto, @PathVariable Integer idTipoProducto, @PathVariable Integer idProducto){
        return tipoProductoService.guardar(tipoProducto, idTipoProducto, idProducto);
    }
    @PostMapping("id/{idTipoProducto}")
    public TipoProducto save(@RequestBody TipoProductoDTO tipoProducto, @PathVariable Integer idProducto){
        return tipoProductoService.guardar(tipoProducto, idProducto);
    }

    @DeleteMapping()
    public void delete(@RequestParam Integer id){
        tipoProductoService.eliminar(id);
    }
}
