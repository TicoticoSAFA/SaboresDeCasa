package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.servicios.CamareroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CamareroTest {

    @Autowired
    private CamareroService camareroService;

    @Test
    void textTodosCamareros(){
        List<Camarero> camareros = camareroService.getAll();
        for (Camarero c : camareros){
            System.out.println(c.toString());
        }
    }

    @Test
    void test1Camarero(){
        System.out.println(camareroService.getById(5));
    }

    @Test
    void textNombreCamarero(){
        System.out.println(camareroService.getCamareroPorNombre("Juan"));
    }

    @Test
    void testCrearCamarero(){
        Camarero camarero = new Camarero();
        camarero.setId(9);
        camarero.setNombre("Paco");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("pacoelwapo@gmail.com");
        Camarero camareroGuardado = camareroService.guardar(camarero);
        System.out.println(camareroGuardado);
    }

    @Test
    void testEditarCamarero(){
        Camarero camarero = camareroService.getById(16);
        camarero.setNombre("Paco");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("pacoelwapo@gmail.com");
        Camarero camareroGuardado = camareroService.guardar(camarero);
        System.out.println(camareroGuardado.toString());
    }

    @Test
    void testEliminar(){
        camareroService.eliminar(9);
    }

}
