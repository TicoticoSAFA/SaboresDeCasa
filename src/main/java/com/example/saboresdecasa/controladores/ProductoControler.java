package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.models.Producto;
import com.example.saboresdecasa.servicios.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@AllArgsConstructor
public class ProductoControler {

    private ProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> getAllProductos(){
        return productoService.getAll();
    }

    @GetMapping()
    public Producto getByIdProducto(@RequestParam Integer id){
        return productoService.getById(id);
    }

    @PostMapping()
    public Producto save(@RequestBody Producto producto){
        return productoService.guardar(producto);
    }

    @DeleteMapping()
    public void delete(@RequestParam Integer id){
        productoService.eliminar(id);
    }
}
