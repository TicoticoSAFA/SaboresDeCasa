package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.MesaDTO;
import com.example.saboresdecasa.models.Mesa;
import com.example.saboresdecasa.servicios.MesaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesa")
@AllArgsConstructor
public class MesaControler {

    private MesaService mesaService;

    @GetMapping("/listar")
    public List<MesaDTO> getAllMesas(){
        return mesaService.getAll();
    }

    @GetMapping()
    public MesaDTO getByIdMesa(@RequestParam Integer id){
        return mesaService.getbyId(id);
    }

    @PostMapping()
    public Mesa save(@RequestBody MesaDTO mesa){
        return mesaService.guardar(mesa);
    }

    @DeleteMapping()
    public void delete(@RequestParam Integer id){
        mesaService.eliminar(id);
    }
}
