package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.LineaPedido;
import com.example.saboresdecasa.repositorios.LineaPedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LineaPedidoService {

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
    public List<LineaPedido> getAll() {
        return lineaPedidoRepository.findAll();
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
     * @param lineaPedido
     * @return
     */
    public LineaPedido guardar(LineaPedido lineaPedido) {
        return lineaPedidoRepository.save(lineaPedido);
    }
}
