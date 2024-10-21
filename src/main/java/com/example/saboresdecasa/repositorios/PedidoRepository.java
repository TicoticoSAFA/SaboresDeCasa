package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.Cliente;
import com.example.saboresdecasa.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

    List<Pedido> findAllByClienteEquals(Cliente cliente);
}
