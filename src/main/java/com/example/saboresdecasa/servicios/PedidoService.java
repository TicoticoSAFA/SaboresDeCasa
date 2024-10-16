package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.LineaPedidoPedidoDTO;
import com.example.saboresdecasa.dto.PedidoDTO;
import com.example.saboresdecasa.dto.PedidoGuardarDTO;
import com.example.saboresdecasa.models.LineaPedido;
import com.example.saboresdecasa.models.Mesa;
import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private LineaPedidoService lineaPedidoService;
    @Autowired
    private TipoProductoService tipoProductoService;
    @Autowired
    private MesaService mesaService;

    /**
     * devuelve todos los pedidos
     * @return
     */
    public List<Pedido> getAll(){
        return pedidoRepository.findAll();
    }

    /**
     * busca un pedido por id
     * @param id
     * @return
     */
    public Pedido getById(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    /**
     * crea o modifica un pedido
     * @param pedido
     * @return
     */
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido guardar(PedidoGuardarDTO pedidoGuardarDTO, Integer idPedido, Integer idMesa) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            pedido = new Pedido();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(pedidoGuardarDTO.getFecha(), formatter);
        pedido.setFecha(date);

        double total = 0.0;

        for (LineaPedidoPedidoDTO lineaPedido : pedidoGuardarDTO.getLineasPedido()) {

            TipoProducto tipoProducto = tipoProductoService.getById(lineaPedido.getIdTipoProducto());

            LineaPedido linea = new LineaPedido();
            linea.setCantidad(lineaPedido.getCantidad());
            linea.setTipoProducto(tipoProducto);
            linea.setPedido(pedido);
            if (pedido.getId() != null) {
                linea.setPedido(pedido);
            }
            if (linea.getId() != null) {
                linea = lineaPedidoService.getById(linea.getId());
            } else {
                lineaPedidoService.guardar(linea);
            }
            total += lineaPedido.getCantidad() * tipoProducto.getPrecio();
        }

        pedido.setPrecio(total);

        Mesa mesa = mesaService.getById(idMesa);
        pedido.setMesa(mesa);

        return pedidoRepository.save(pedido);
    }

    /**
     * elimina un pedido
     * @param id
     */
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }

    /**
     * guarda un pedido con formato de dto
     * @param pedidoDTO
     * @param idPedido
     * @return
     */
    public Pedido guardar(PedidoDTO pedidoDTO, Integer idPedido, Integer idMesa) {
        Pedido pedido = pedidoRepository.findById(idPedido).orElse(null);
        if (pedido == null) {
            pedido = new Pedido();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(pedidoDTO.getFecha(), formatter);
        pedido.setFecha(date);
        pedido.setPrecio(pedidoDTO.getTotal());

        Mesa mesa = mesaService.getById(idMesa);
        pedido.setMesa(mesa);

        return pedidoRepository.save(pedido);
    }
}
