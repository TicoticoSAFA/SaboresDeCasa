package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.CamareroDTO;
import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.servicios.CamareroService;
import jakarta.servlet.ServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/camarero")
@AllArgsConstructor
public class CamareroControler {

    private CamareroService camareroService;

    @GetMapping("/listar")
    public List<CamareroDTO> getAllCamareros(){
        List<Camarero> camareros = camareroService.getAll();

        List<CamareroDTO> camareroDTOList = new ArrayList<>();

        for (Camarero i : camareros){
            CamareroDTO camareroDTO = new CamareroDTO();
            camareroDTO.setNombre(i.getNombre());
            camareroDTO.setApellidos(i.getApellidos());
            camareroDTO.setMail(i.getEmail());
            camareroDTOList.add(camareroDTO);
        }

        return camareroDTOList;
    }

    @GetMapping()
    public Camarero getByIdCamarero(@RequestParam Integer id){
        return camareroService.getById(id);
    }

    @GetMapping("/get/{id}")
    public Camarero getByIdPath (@PathVariable Integer id){
        return camareroService.getById(id);
    }

    @PostMapping()
    public Camarero save(@RequestBody Camarero camarero){
        return camareroService.guardar(camarero);
    }

    @DeleteMapping()
    public String delete(@RequestParam Integer id){
        return camareroService.eliminar(id);
    }


}
