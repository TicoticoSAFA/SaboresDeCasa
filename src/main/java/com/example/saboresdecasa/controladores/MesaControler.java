package com.example.saboresdecasa.controladores;

import com.example.saboresdecasa.dto.MesaDTO;
import com.example.saboresdecasa.dto.MesaSaveDTO;
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

    @PostMapping("id/{idMesa}/{idCamarero}")
    public Mesa save(@RequestBody MesaSaveDTO mesa, @PathVariable Integer idMesa, @PathVariable Integer idCamarero){
        return mesaService.guardar(mesa, idMesa, idCamarero);
    }

    @PostMapping("id/{idCamarero}")
    public Mesa save(@RequestBody MesaSaveDTO mesa, @PathVariable Integer idCamarero){
        return mesaService.guardar(mesa, idCamarero);
    }

    @DeleteMapping()
    public void delete(@RequestParam Integer id){
        mesaService.eliminar(id);
    }
}
