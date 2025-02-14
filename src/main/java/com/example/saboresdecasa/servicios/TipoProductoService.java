package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.ProductoDTO;
import com.example.saboresdecasa.dto.TipoProductoDTO;
import com.example.saboresdecasa.dto.TipoProductoEditarDTO;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
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

            Producto producto = tipoProducto.getProducto();
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(producto.getNombre());
            productoDTO.setDescripcion(producto.getDescripcion());

            tipoProductoDTO.setProducto(productoDTO);

            tipoProductoDTO.setTipo(tipoProducto.getTipo());
            tipoProductoDTO.setTamanyo(tipoProducto.getTamanyo());
            tipoProductoDTO.setPrecio(tipoProducto.getPrecio());
            tipoProductoDTOList.add(tipoProductoDTO);
        }
        return tipoProductoDTOList;
    }

    /**
     * devuelve un Tipo producto pasando un id
     * @param id
     * @return
     */
    public TipoProducto getById(Integer id){
        return tipoProductoRepository.findById(id).orElse(null);

//        TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
//        TipoProducto tipoProducto = tipoProductoRepository.findById(id).orElse(null);
//
//        if (tipoProducto == null) {
//            return null;
//        }
//
//        tipoProductoDTO.setPrecio(tipoProducto.getPrecio());
//        tipoProductoDTO.setTamanyo(tipoProducto.getTamanyo());
//        tipoProductoDTO.setTipo(tipoProducto.getTipo());
//
//        ProductoDTO productoDTO = new ProductoDTO();
//        Producto producto = tipoProducto.getProducto();
//        productoDTO.setNombre(producto.getNombre());
//        productoDTO.setDescripcion(producto.getDescripcion());
//
//        tipoProductoDTO.setProducto(productoDTO);
//
//        return tipoProductoDTO;
    }

    /**
     * guarda o modifica un tipo producto
     * @param dto
     * @return
     */
    public TipoProducto guardar(TipoProductoDTO dto, Integer idProducto, Integer idTipoProducto){
        TipoProducto entity = tipoProductoRepository.findById(idTipoProducto).orElse(null);

        entity.setPrecio(dto.getPrecio());
        entity.setTamanyo(dto.getTamanyo());
        entity.setTipo(dto.getTipo());

        Producto producto = productoService.getById(idProducto);
        entity.setProducto(producto);

        return tipoProductoRepository.save(entity);
    }

    public TipoProducto guardar(TipoProductoDTO dto, Integer idProducto){
        TipoProducto entity = new TipoProducto();
        entity.setPrecio(dto.getPrecio());
        entity.setTamanyo(dto.getTamanyo());
        entity.setTipo(dto.getTipo());


        Producto producto = productoService.getById(idProducto);
        entity.setProducto(producto);

        return tipoProductoRepository.save(entity);
    }

    public TipoProducto guardarPrecio(TipoProductoEditarDTO dto){

        List<TipoProducto> tipoProductosTipo = tipoProductoRepository.findAllByTipoEquals(TipoTipoProducto.valueOf(dto.getTipo()));

        if (tipoProductosTipo == null) {
            return null;
        }

        TipoProducto entity = tipoProductosTipo.stream()
            .filter(tipoProducto -> tipoProducto.getProducto().getId().equals(dto.getIdProducto()))
            .findFirst()
            .orElse(null);

        if (entity == null) {
            return null;
        }

        entity.setPrecio(dto.getPrecio());

        return tipoProductoRepository.save(entity);
    }

    /**
     * elimina un tipo producto
     * @param id
     */
    public void eliminar(Integer id){
        tipoProductoRepository.deleteById(id);
    }

    public List<TipoProducto> getAllByTipo(TipoTipoProducto tipo){
        return tipoProductoRepository.findAllByTipoEquals(tipo);
    }
}
