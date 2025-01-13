package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.servicios.CamareroService;
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
public class CamareroTest {

    @Autowired
    private CamareroService camareroService;

    @BeforeEach
    public void inicializarDatos() {
        Camarero camarero = new Camarero();
        camarero.setId(1);
        camarero.setNombre("Juan");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("Jperez@prueba.com");
        camareroService.guardar(camarero);

        Camarero camarero2 = new Camarero();
        camarero2.setId(2);
        camarero2.setNombre("Ana");
        camarero2.setApellidos("García López");
        camarero2.setDni("12345678A");
        camarero2.setEmail("ana.garcia@prueba.com");
        camareroService.guardar(camarero2);

        Camarero camarero3 = new Camarero();
        camarero3.setId(3);
        camarero3.setNombre("Luis");
        camarero3.setApellidos("Martínez Ruiz");
        camarero3.setDni("87654321B");
        camarero3.setEmail("luis.martinez@prueba.com");
        camareroService.guardar(camarero3);
    }

    @Test
    void getAllCamareros() {
        List<Camarero> camareros = camareroService.getAll();
        assertNotNull(camareros);
        assertFalse(camareros.isEmpty());
    }

    @Test
    void getCamareroPorId() throws Exception {
        Camarero camarero = camareroService.getById(1);
        assertNotNull(camarero);
        assertEquals("Juan", camarero.getNombre());
    }

    @Test
    void getCamareroPorIdNoExiste() {
        Exception exception = assertThrows(Exception.class, () -> {
            Camarero camarero = camareroService.getById(4);
        });
        assertEquals("No existe ningún camarero con el id indicado", exception.getMessage());
    }

    @Test
    void guardarCamarero() {
        Camarero camarero = new Camarero();
        camarero.setId(4);
        camarero.setNombre("María");
        camarero.setApellidos("González Pérez");
        camarero.setDni("98765432C");
        camarero.setEmail("Mgonzalez@gmail.com");
        Camarero camareroGuardado = camareroService.guardar(camarero);
        assertNotNull(camareroGuardado);
        assertEquals("María", camareroGuardado.getNombre());
    }

    @Test
    void guardarCamareroSinNombre() {
        Camarero camarero = new Camarero();
        camarero.setId(5);
        camarero.setApellidos("González Pérez");
        camarero.setDni("98765432C");
        camarero.setEmail("Mgonzalez@gmail.com");
        Camarero camareroGuardado = camareroService.guardar(camarero);
        assertNull(camareroGuardado);
    }

    @Test
    void eliminarCamarero() {
        camareroService.eliminar(1);
        Exception exception = assertThrows(Exception.class, () -> {
            Camarero camarero = camareroService.getById(1);
        });
        assertEquals("No existe ningún camarero con el id indicado", exception.getMessage());
    }

    @Test
    void eliminarCamareroNoExiste() {
        Exception exception = assertThrows(Exception.class, () -> {
            camareroService.eliminar(4);
        });
        assertEquals("No existe ningún camarero con el id indicado", exception.getMessage());
    }
}
