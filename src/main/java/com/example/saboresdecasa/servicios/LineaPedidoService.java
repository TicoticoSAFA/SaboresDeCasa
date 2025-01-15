package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.*;
import com.example.saboresdecasa.models.*;
import com.example.saboresdecasa.repositorios.LineaPedidoRepository;
import com.example.saboresdecasa.repositorios.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LineaPedidoService {

    private final PedidoService pedidoService;
    private final ClienteService clienteService;
    private final MesaService mesaService;
    private final TipoProductoService tipoProductoService;
    private final PedidoRepository pedidoRepository;
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

            TipoProductoDTO tipoProductoDTO = new TipoProductoDTO();
            tipoProductoDTO.setTipo(lineaPedido.getTipoProducto().getTipo());
            tipoProductoDTO.setTamanyo(lineaPedido.getTipoProducto().getTamanyo());
            tipoProductoDTO.setPrecio(lineaPedido.getTipoProducto().getPrecio());
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
     * @param pedidoGuardarDTO
     * @return
     */
    public Pedido crearPedido(PedidoGuardarDTO pedidoGuardarDTO) {
        Pedido pedido = new Pedido();

        pedido.setFecha(LocalDate.now());

        Cliente cliente = clienteService.getById(pedidoGuardarDTO.getIdCliente());
        pedido.setCliente(cliente);

        Mesa mesa = mesaService.getById(pedidoGuardarDTO.getIdMesa());
        pedido.setMesa(mesa);

        List<LineaPedidoGuardarPedidoDTO> lineasPedido = pedidoGuardarDTO.getLineasPedido();
        List<LineaPedido> lineasPedido1 = new ArrayList<>();
        double precio = 0.0;

        if (lineasPedido == null || lineasPedido.isEmpty()) {
            return null;
        }
        for (LineaPedidoGuardarPedidoDTO lineaPedido : lineasPedido) {
            LineaPedido lineaPedido1 = new LineaPedido();
            lineaPedido1.setCantidad(lineaPedido.getCantidad());
            TipoProducto tipoProducto = tipoProductoService.getById(lineaPedido.getIdTipoProducto());
            lineaPedido1.setTipoProducto(tipoProducto);
            lineaPedido1.setPedido(pedido);
            precio += lineaPedido1.getCantidad() * lineaPedido1.getTipoProducto().getPrecio();
            lineasPedido1.add(lineaPedido1);
        }

        pedido.setPrecio(precio);

        Pedido pedido1 = pedidoRepository.save(pedido);

        for (LineaPedido lineaPedido : lineasPedido1) {
            guardar(lineaPedido);
        }

        return pedido1;
    }

    public LineaPedido guardar(LineaPedido lineaPedido) {
        return lineaPedidoRepository.save(lineaPedido);
    }

    /**
     * obtener todas las lineas de pedido de un pedido
     *
     * @param idpedido
     * @return
     */
    public CuentaDTO getCuenta(Integer idpedido) {
        try {
            Pedido pedido = pedidoService.getById(idpedido);
            List<LineaPedido> lineaPedidos = lineaPedidoRepository.findByPedido(pedido);

            CuentaDTO cuentaDTO = new CuentaDTO();

            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setFecha(pedido.getFecha().toString());
            pedidoDTO.setTotal(pedido.getPrecio());

            MesaPedidoDTO mesaDTO = new MesaPedidoDTO();
            mesaDTO.setNumero(pedido.getMesa().getNumero());
            pedidoDTO.setMesa(mesaDTO);

            cuentaDTO.setPedido(pedidoDTO);

            List<CuentaLineaPedidoDTO> cuentaLineaPedidoDTOS = new ArrayList<>();
            for (LineaPedido lineaPedido : lineaPedidos) {
                CuentaLineaPedidoDTO cuentaLineaPedidoDTO = new CuentaLineaPedidoDTO();
                cuentaLineaPedidoDTO.setId(lineaPedido.getId());
                cuentaLineaPedidoDTO.setCantidad(lineaPedido.getCantidad());
                cuentaLineaPedidoDTO.setTipoProducto(lineaPedido.getTipoProducto());
                cuentaLineaPedidoDTOS.add(cuentaLineaPedidoDTO);
            }
            cuentaDTO.setLineas(cuentaLineaPedidoDTOS);
            return cuentaDTO;
        } catch (Exception e) {
            return null;
        }

    }
}
