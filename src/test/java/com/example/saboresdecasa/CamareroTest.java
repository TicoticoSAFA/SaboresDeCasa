package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.servicios.CamareroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CamareroTest {

    @Autowired
    private CamareroService camareroService;

    @Test
    void testCrearCamarero(){
        Camarero camarero = new Camarero();
        camarero.setNombre("Paco");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("pacoelwapo@gmail.com");
        Camarero camareroGuardado = camareroService.guardar(camarero);
        System.out.println(camareroGuardado);
    }

    void testEditarCamarero(){
        Camarero camarero = new Camarero();
        camarero.setNombre("Paco");
        camarero.setApellidos("Pérez Marquez");
        camarero.setDni("74185296D");
        camarero.setEmail("pacoelwapo@gmail.com");
        Camarero camareroGuardado = camareroService.guardar(camarero);
        System.out.println(camareroGuardado);
    }

}
