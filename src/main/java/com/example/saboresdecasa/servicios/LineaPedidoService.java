package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.*;
import com.example.saboresdecasa.models.LineaPedido;
import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.LineaPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LineaPedidoService {

    private final PedidoService pedidoService;
    private final TipoProductoService tipoProductoService;
    private final ProductoService productoService;
    private LineaPedidoRepository lineaPedidoRepository;

    /**
     * eliminar una linea de pedido
     *
     * @param id
     */
    public void eliminar(Integer id) {
        lineaPedidoRepository.deleteById(id);
    }

    /**
     * obtener todas las lineas de pedido
     *
     * @return
     */
    public List<LineaPedidoDTO> getAll() {
        List<LineaPedidoDTO> lineaPedidoDTOS = new ArrayList<>();
        List<LineaPedido> lineaPedidos = lineaPedidoRepository.findAll();

        for (LineaPedido lineaPedido : lineaPedidos) {
            LineaPedidoDTO lineaPedidoDTO = new LineaPedidoDTO();
            lineaPedidoDTO.setCantidad(lineaPedido.getCantidad());

            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(lineaPedido.getProducto().getNombre());
            productoDTO.setDescripcion(lineaPedido.getProducto().getDescripcion());
            lineaPedidoDTO.setProducto(productoDTO);

            lineaPedidoDTO.setProducto(productoDTO);

            TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
            tipoProductoDTO.setTipo(lineaPedido.getTipoProducto().getTipo());
            tipoProductoDTO.setTamanyo(lineaPedido.getTipoProducto().getTamanyo());
            tipoProductoDTO.setPrecio(lineaPedido.getTipoProducto().getPrecio());
            tipoProductoDTO.setProducto(productoDTO);
            lineaPedidoDTO.setTipoProducto(tipoProductoDTO);

            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setFecha(lineaPedido.getPedido().getFecha().toString());
            pedidoDTO.setTotal(lineaPedido.getPedido().getPrecio());

            lineaPedidoDTO.setPedido(pedidoDTO);

            lineaPedidoDTOS.add(lineaPedidoDTO);
        }
        return lineaPedidoDTOS;
    }

    /**
     * obtener una linea de pedido por id
     *
     * @param id
     * @return
     */
    public LineaPedido getById(Integer id) {
        return lineaPedidoRepository.findById(id).orElse(null);
    }

    /**
     * crear o modificar una linea de pedido
     *
     * @param dto
     * @param idPedido
     * @param idTipoProducto
     * @return
     */
    public LineaPedido guardar(LineaPedidoGuardarDTO dto, Integer idPedido, Integer idTipoProducto) {
        LineaPedido lineaPedido = new LineaPedido();

        lineaPedido.setCantidad(dto.getCantidad());

        Pedido pedido = pedidoService.getById(idPedido);
        TipoProducto tipoProducto = tipoProductoService.getById(idTipoProducto);

        Double total = dto.getCantidad() * tipoProducto.getPrecio();

        pedido.setPrecio(pedido.getPrecio() + total);

        lineaPedido.setPedido(pedidoService.guardar(pedido));
        lineaPedido.setTipoProducto(tipoProducto);

        return lineaPedidoRepository.save(lineaPedido);
    }
}
