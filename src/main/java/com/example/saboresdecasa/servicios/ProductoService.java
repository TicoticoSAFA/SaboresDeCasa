package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.Producto;
import com.example.saboresdecasa.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * devuelve todos los productos
     * @return
     */
    public List<Producto> getAll(){
        return productoRepository.findAll();
    }

    /**
     * devuelve un producto por su id
     * @param id
     * @return
     */
    public Producto getById(Integer id){
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * guarda o modifica un producto
     * @param producto
     * @return
     */
    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    /**
     * elimina un producto por su id
     * @param id
     */
    public void eliminar(Integer id){
        productoRepository.deleteById(id);
    }
}
