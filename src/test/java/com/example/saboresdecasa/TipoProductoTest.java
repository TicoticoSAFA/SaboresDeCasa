package com.example.saboresdecasa;

import com.example.saboresdecasa.dto.TipoProductoDTO;
import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.Producto;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.TipoProductoRepository;
import com.example.saboresdecasa.servicios.TipoProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
//@Transactional
public class TipoProductoTest {

    @Autowired
    private TipoProductoService tipoProductoService;
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @BeforeEach
    void inicializarDatos() {
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

        Producto producto4 = new Producto();
        producto4.setNombre("Cerveza artesanal IPA");
        producto4.setDescripcion("Cerveza artesanal tipo IPA con notas cítricas y amargas.");

        TipoProducto tipoProducto4 = new TipoProducto();
        tipoProducto4.setTipo(TipoTipoProducto.CERVEZAS);
        tipoProducto4.setPrecio(3.00);
        tipoProducto4.setTamanyo(TamanyoTipoProducto.BOTELLIN);
        tipoProducto4.setProducto(producto4);

        Producto producto5 = new Producto();
        producto5.setNombre("Copa de vino tinto");
        producto5.setDescripcion("Vino tinto crianza de excelente calidad, servido en copa.");

        TipoProducto tipoProducto5 = new TipoProducto();
        tipoProducto5.setTipo(TipoTipoProducto.VINOS);
        tipoProducto5.setPrecio(4.00);
        tipoProducto5.setTamanyo(TamanyoTipoProducto.COPA);
        tipoProducto5.setProducto(producto5);

        Producto producto6 = new Producto();
        producto6.setNombre("Infusión de manzanilla");
        producto6.setDescripcion("Infusión natural de manzanilla con propiedades relajantes.");

        TipoProducto tipoProducto6 = new TipoProducto();
        tipoProducto6.setTipo(TipoTipoProducto.INFUSIONES);
        tipoProducto6.setPrecio(2.50);
        tipoProducto6.setTamanyo(TamanyoTipoProducto.UNIDAD);
        tipoProducto6.setProducto(producto6);

        tipoProductoRepository.save(tipoProducto1);
        tipoProductoRepository.save(tipoProducto2);
        tipoProductoRepository.save(tipoProducto3);
        tipoProductoRepository.save(tipoProducto4);
        tipoProductoRepository.save(tipoProducto5);
        tipoProductoRepository.save(tipoProducto6);
    }

    @Test
    void carta() {
        List<TipoProductoDTO> tipoProductos = tipoProductoService.getAll();
        assertEquals(6, tipoProductos.size());
        assertFalse(tipoProductos.isEmpty());
    }

    @Test
    void getAllByTipo() {
        List<TipoProducto> tipoProductos = tipoProductoService.getAllByTipo(TipoTipoProducto.MONTADITOS);
        assertEquals(1, tipoProductos.size());
        assertFalse(tipoProductos.isEmpty());
    }
}
