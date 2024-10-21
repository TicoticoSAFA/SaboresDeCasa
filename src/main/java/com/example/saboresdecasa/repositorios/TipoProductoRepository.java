package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto,Integer> {
    List<TipoProducto> findAllByTipoEquals(TipoTipoProducto tipoTipoProducto);
}
