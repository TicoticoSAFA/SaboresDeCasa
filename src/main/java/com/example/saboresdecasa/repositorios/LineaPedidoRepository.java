package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.LineaPedido;
import com.example.saboresdecasa.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido,Integer> {
    List<LineaPedido> findByPedido(Pedido pedido);
}
