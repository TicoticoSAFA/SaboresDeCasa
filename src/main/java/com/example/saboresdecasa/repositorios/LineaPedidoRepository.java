package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaPedidoRepository extends JpaRepository<Pedido,Integer> {
}
