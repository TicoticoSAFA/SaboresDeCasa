package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.repositorios.CamareroRepository;
import com.example.saboresdecasa.servicios.CamareroService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CamareroServiceIntegrationTest {

    @InjectMocks
    private CamareroService camareroService;

    @Mock
    private CamareroRepository camareroRepository;

    @Test
    public void testFindAllIntegracion() {
        //GIVEN
        Camarero camarero = new Camarero();
        camarero.setId(1);
        camarero.setNombre("Juan");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("Jperez@prueba.com");

        Camarero camarero2 = new Camarero();
        camarero2.setId(2);
        camarero2.setNombre("Ana");
        camarero2.setApellidos("García López");
        camarero2.setDni("12345678A");
        camarero2.setEmail("ana.garcia@prueba.com");

        Camarero camarero3 = new Camarero();
        camarero3.setId(3);
        camarero3.setNombre("Luis");
        camarero3.setApellidos("Martínez Ruiz");
        camarero3.setDni("87654321B");
        camarero3.setEmail("luis.martinez@prueba.com");

        List<Camarero> camareroslist = new ArrayList<>(List.of(camarero, camarero2, camarero3));
        //WHEN
        Mockito.when(camareroRepository.findAll()).thenReturn(camareroslist);

        //THEN
       assertEquals(3, camareroService.getAll().size());
       Mockito.verify(camareroRepository, Mockito.times(1)).findAll();

    }

    @Test
    public void testFindByIdIntegracion() throws Exception {
        //GIVEN
        Mockito.when(camareroRepository.findById(Mockito.any())).thenReturn(Optional.ofNullable(null));
        //WHEN & THEN
        assertThrows(Exception.class, () -> camareroService.getById(1));
        Mockito.verify(camareroRepository, Mockito.times(1)).findById(Mockito.any());
    }

    @Test
    public void testSaveIntegracion() {
        //GIVEN
        Camarero camarero = new Camarero();
        camarero.setId(1);
        camarero.setNombre("Juan");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("jperezm@prueba.com");

        //WHEN & THEN
        Mockito.when(camareroRepository.save(Mockito.any())).thenReturn(camarero);
        assertNotNull(camareroService.guardar(camarero));
        Mockito.verify(camareroRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void eliminarCamareroExistente() throws Exception {
        //GIVEN
        Integer id = 1;
        Mockito.doNothing().when(camareroRepository).deleteById(id);

        //WHEN
        String resultado = camareroService.eliminar(id);

        //THEN
        assertEquals("Se ha eliminado el camarero", resultado);
        Mockito.verify(camareroRepository, Mockito.times(1)).deleteById(id);
    }

    @Test
    public void eliminarCamareroNoExistente() {
        //GIVEN
        Integer id = 1;
        Mockito.doThrow(new RuntimeException()).when(camareroRepository).deleteById(id);

        //WHEN & THEN
        Exception exception = assertThrows(Exception.class, () -> camareroService.eliminar(id));
        assertEquals("No existe ningún camarero con el id indicado", exception.getMessage());
        Mockito.verify(camareroRepository, Mockito.times(1)).deleteById(id);
    }
}
