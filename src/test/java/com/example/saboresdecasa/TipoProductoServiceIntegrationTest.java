package com.example.saboresdecasa;

import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.Producto;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.CamareroRepository;
import com.example.saboresdecasa.repositorios.TipoProductoRepository;
import com.example.saboresdecasa.servicios.CamareroService;
import com.example.saboresdecasa.servicios.TipoProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TipoProductoServiceIntegrationTest {

    @InjectMocks
    private TipoProductoService tipoProductoService;

    @Mock
    private TipoProductoRepository tipoProductoRepository;

    @Test
    public void carta(){
        Producto producto1 = new Producto();
        producto1.setNombre("Montadito de jamón ibérico");
        producto1.setDescripcion("Montadito elaborado con pan crujiente y jamón ibérico de bellota.");

        TipoProducto tipoProducto1 = new TipoProducto();
        tipoProducto1.setTipo(TipoTipoProducto.MONTADITOS);
        tipoProducto1.setPrecio(3.50);
        tipoProducto1.setTamanyo(TamanyoTipoProducto.UNIDAD);
        tipoProducto1.setProducto(producto1);

        Producto producto2 = new Producto();
        producto2.setNombre("Calamares fritos");
        producto2.setDescripcion("Calamares frescos rebozados y fritos al estilo tradicional.");

        TipoProducto tipoProducto2 = new TipoProducto();
        tipoProducto2.setTipo(TipoTipoProducto.PLATOSDELMARFRITO);
        tipoProducto2.setPrecio(10.00);
        tipoProducto2.setTamanyo(TamanyoTipoProducto.RACION);
        tipoProducto2.setProducto(producto2);

        Producto producto3 = new Producto();
        producto3.setNombre("Tarta de queso casera");
        producto3.setDescripcion("Tarta de queso elaborada de manera artesanal con base de galleta.");

        TipoProducto tipoProducto3 = new TipoProducto();
        tipoProducto3.setTipo(TipoTipoProducto.POSTRES);
        tipoProducto3.setPrecio(4.75);
        tipoProducto3.setTamanyo(TamanyoTipoProducto.UNIDAD);
        tipoProducto3.setProducto(producto3);

        List<TipoProducto> tipoProductos = List.of(tipoProducto1, tipoProducto2, tipoProducto3);
        Mockito.when(tipoProductoRepository.findAll()).thenReturn(tipoProductos);

        assertEquals(3, tipoProductoService.getAll().size());
        Mockito.verify(tipoProductoRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void getAllByTipo(){
        Producto producto1 = new Producto();
        producto1.setNombre("Montadito de jamón ibérico");
        producto1.setDescripcion("Montadito elaborado con pan crujiente y jamón ibérico de bellota.");

        TipoProducto tipoProducto1 = new TipoProducto();
        tipoProducto1.setTipo(TipoTipoProducto.MONTADITOS);
        tipoProducto1.setPrecio(3.50);
        tipoProducto1.setTamanyo(TamanyoTipoProducto.UNIDAD);
        tipoProducto1.setProducto(producto1);

        Producto producto2 = new Producto();
        producto2.setNombre("Calamares fritos");
        producto2.setDescripcion("Calamares frescos rebozados y fritos al estilo tradicional.");

        TipoProducto tipoProducto2 = new TipoProducto();
        tipoProducto2.setTipo(TipoTipoProducto.PLATOSDELMARFRITO);
        tipoProducto2.setPrecio(10.00);
        tipoProducto2.setTamanyo(TamanyoTipoProducto.RACION);
        tipoProducto2.setProducto(producto2);

        Producto producto3 = new Producto();
        producto3.setNombre("Tarta de queso casera");
        producto3.setDescripcion("Tarta de queso elaborada de manera artesanal con base de galleta.");

        TipoProducto tipoProducto3 = new TipoProducto();
        tipoProducto3.setTipo(TipoTipoProducto.POSTRES);
        tipoProducto3.setPrecio(4.75);
        tipoProducto3.setTamanyo(TamanyoTipoProducto.UNIDAD);
        tipoProducto3.setProducto(producto3);

        List<TipoProducto> tipoProductos = List.of(tipoProducto1, tipoProducto2, tipoProducto3);
        Mockito.when(tipoProductoRepository.findAllByTipoEquals(TipoTipoProducto.MONTADITOS)).thenReturn(List.of(tipoProducto1));

        assertEquals(1, tipoProductoService.getAllByTipo(TipoTipoProducto.MONTADITOS).size());
        Mockito.verify(tipoProductoRepository, Mockito.times(1)).findAllByTipoEquals(TipoTipoProducto.MONTADITOS);
    }
}
