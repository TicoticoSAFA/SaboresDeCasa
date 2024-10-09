package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.TipoProductoDTO;
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

    @GetMapping("/listar")
    public List<TipoProductoDTO> getAllTipoProducto(){
        return tipoProductoService.getAll();
    }

    @GetMapping()
    public TipoProductoDTO getByIdTipoProducto(@RequestParam  Integer id){
        return tipoProductoService.getById(id);
    }

    @PostMapping()
    public TipoProducto save(@RequestBody TipoProductoDTO tipoProducto){
        return tipoProductoService.guardar(tipoProducto);
    }

    @DeleteMapping()
    public void delete(@RequestParam Integer id){
        tipoProductoService.eliminar(id);
    }
}
