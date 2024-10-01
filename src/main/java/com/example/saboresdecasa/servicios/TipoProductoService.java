package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    /**
     * devuelve todos los tipo producto
     * @return
     */
    public List<TipoProducto> getAll(){
        return tipoProductoRepository.findAll();
    }

    /**
     * devuelve un Tipo producto pasando un id
     * @param id
     * @return
     */
    public TipoProducto getById(Integer id){
        return tipoProductoRepository.findById(id).orElse(null);
    }

    /**
     * guarda o modifica un tipo producto
     * @param tipoProducto
     * @return
     */
    public TipoProducto guardar(TipoProducto tipoProducto){
        return tipoProductoRepository.save(tipoProducto);
    }

    /**
     * elimina un tipo producto
     * @param id
     */
    public void eliminar(Integer id){
        tipoProductoRepository.deleteById(id);
    }
}
