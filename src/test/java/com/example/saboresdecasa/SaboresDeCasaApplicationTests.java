package com.example.saboresdecasa;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.models.TipoProducto;
import com.example.saboresdecasa.repositorios.CamareroRepository;
import com.example.saboresdecasa.servicios.CamareroService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootTest
@Service
@AllArgsConstructor
class SaboresDeCasaApplicationTests {

    private CamareroService camareroService;

    @Test
    public void getCamarerosByNombre(){
        List<Camarero> camareros = camareroService.getCamareroPorNombre("Alberto");
        for (Camarero i : camareros) {
            System.out.println(i);
        }
    }


}
