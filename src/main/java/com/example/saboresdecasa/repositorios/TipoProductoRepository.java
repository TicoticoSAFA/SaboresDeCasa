package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoProductoRepository extends JpaRepository<TipoProducto,Integer> {

    List<TipoProducto> findAllByTipo(String tipo);

}
