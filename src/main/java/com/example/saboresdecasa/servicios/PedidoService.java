package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.*;
import com.example.saboresdecasa.models.*;
import com.example.saboresdecasa.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private TipoProductoService tipoProductoService;
    @Autowired
    private MesaService mesaService;
    @Autowired
    private ClienteService clienteService;

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

    public PedidoClientesDTO getClientes(Integer idCliente){
        PedidoClientesDTO pedidoClientesDTO = new PedidoClientesDTO();

        Cliente cliente = clienteService.getById(idCliente);
        List<Pedido> pedidos = pedidoRepository.findAllByClienteEquals(cliente);

        List<PedidoDTO> pedidoDTOList = new ArrayList<>();

        for (Pedido pedido : pedidos) {
            PedidoDTO pedidoDTO = new PedidoDTO();
            pedidoDTO.setFecha(pedido.getFecha().toString());
            pedidoDTO.setTotal(pedido.getPrecio());

            MesaPedidoDTO mesaDTO = new MesaPedidoDTO();
            mesaDTO.setNumero(pedido.getMesa().getNumero());

            pedidoDTO.setMesa(mesaDTO);
            pedidoDTO.setTotal(pedido.getPrecio());

            pedidoDTOList.add(pedidoDTO);
        }

        pedidoClientesDTO.setPedidos(pedidoDTOList);
        pedidoClientesDTO.setTotal(pedidoDTOList.stream().mapToDouble(PedidoDTO::getTotal).sum());

        return pedidoClientesDTO;
    }
}
