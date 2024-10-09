package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.ProductoDTO;
import com.example.saboresdecasa.dto.TipoProductoDTO;
import com.example.saboresdecasa.models.Producto;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoProductoService {

    @Autowired
    private TipoProductoRepository tipoProductoRepository;
    @Autowired
    private ProductoService productoService;

    /**
     * devuelve todos los tipo producto
     * @return
     */
    public List<TipoProductoDTO> getAll(){
        List<TipoProducto> tipoProductos = tipoProductoRepository.findAll();
        List<TipoProductoDTO> tipoProductoDTOList = new ArrayList<>();
        for (TipoProducto tipoProducto : tipoProductos) {
            TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
            tipoProductoDTO.setId(tipoProducto.getId());

            Producto producto = tipoProducto.getProducto();
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setId(producto.getId());
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setDescripcion(producto.getDescripcion());

            tipoProductoDTO.setProducto(productoDTO);

            tipoProductoDTO.setTipo(tipoProducto.getTipo());
            tipoProductoDTO.setTamanyo(tipoProducto.getTamanyo());
            tipoProductoDTO.setPrecio(tipoProducto.getPrecio());
            tipoProductoDTO.setId(tipoProducto.getId());
            tipoProductoDTOList.add(tipoProductoDTO);
        }
        return tipoProductoDTOList;
    }

    /**
     * devuelve un Tipo producto pasando un id
     * @param id
     * @return
     */
    public TipoProductoDTO getById(Integer id){
        TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
        TipoProducto tipoProducto = tipoProductoRepository.findById(id).orElse(null);

        if (tipoProducto == null) {
            return null;
        }

        tipoProductoDTO.setId(tipoProducto.getId());
        tipoProductoDTO.setPrecio(tipoProducto.getPrecio());
        tipoProductoDTO.setTamanyo(tipoProducto.getTamanyo());
        tipoProductoDTO.setTipo(tipoProducto.getTipo());

        ProductoDTO productoDTO = new ProductoDTO();
        Producto producto = tipoProducto.getProducto();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());

        tipoProductoDTO.setProducto(productoDTO);

        return tipoProductoDTO;
    }

    /**
     * guarda o modifica un tipo producto
     * @param dto
     * @return
     */
    public TipoProducto guardar(TipoProductoDTO dto){
        TipoProducto entity = new TipoProducto();
        if (dto.getId() != null) {
            entity = tipoProductoRepository.findById(dto.getId()).orElse(null);
        }
        entity.setPrecio(dto.getPrecio());
        entity.setTamanyo(dto.getTamanyo());
        entity.setTipo(dto.getTipo());

        Producto producto = productoService.getById(dto.getProducto().getId());
        entity.setProducto(producto);

        return tipoProductoRepository.save(entity);
    }

    /**
     * elimina un tipo producto
     * @param id
     */
    public void eliminar(Integer id){
        tipoProductoRepository.deleteById(id);
    }
}
