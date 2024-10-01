package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.Pedido;
import com.example.saboresdecasa.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

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


}
