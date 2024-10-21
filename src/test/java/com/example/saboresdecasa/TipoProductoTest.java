package com.example.saboresdecasa;

import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.servicios.TipoProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TipoProductoTest {

    @Autowired
    private TipoProductoService tipoProductoService;

    @Test
    void testFindByTipo() {
        List<TipoProducto> tipoProductos = tipoProductoService.getAllByTipo(TipoTipoProducto.valueOf("MONTADITOS"));
        for (TipoProducto i : tipoProductos){
            System.out.println(i.toString());
        }
    }
}
