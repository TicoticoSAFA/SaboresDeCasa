package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.CamareroDTO;
import com.example.saboresdecasa.dto.MesaDTO;
import com.example.saboresdecasa.dto.MesaSaveDTO;
import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.models.Mesa;
import com.example.saboresdecasa.repositorios.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MesaService {

    private final CamareroService camareroService;
    private MesaRepository mesaRepository;


    private static MesaDTO getMesaDTO(Mesa mesa) {
        MesaDTO dto = new MesaDTO();
        dto.setNumero(mesa.getNumero());

        CamareroDTO camareroDTO = new CamareroDTO();
        Camarero camarero = mesa.getCamarero();
        camareroDTO.setNombre(camarero.getNombre());
        camareroDTO.setDni(camarero.getDni());
        camareroDTO.setMail(camarero.getEmail());
        camareroDTO.setApellidos(camarero.getApellidos());

        dto.setCamarero(camareroDTO);
        return dto;
    }

    /**
     * devuelve todas las mesas
     *
     * @return
     */
    public List<MesaDTO> getAll() {
        List<Mesa> mesasList = mesaRepository.findAll();
        List<MesaDTO> mesaDTOList = new ArrayList<>();
        for (Mesa m : mesasList) {
            MesaDTO dto = getMesaDTO(m);
            mesaDTOList.add(dto);
        }
        return mesaDTOList;
    }

    /**
     * busca mesa por id
     *
     * @param id
     * @return
     */
    public MesaDTO getbyId(Integer id) {
        Mesa mesa = mesaRepository.findById(id).orElse(null);
        if (mesa == null) {
            return null;
        }
        return getMesaDTO(mesa);
    }

    public Mesa getById(Integer id){
        return mesaRepository.findById(id).orElse(null);
    }

    /**
     * crea o modifica una mesa
     *
     * @param dto
     * @return
     */
    public Mesa guardar(MesaSaveDTO dto, Integer idMesa, Integer idCamarero) throws Exception {
        Mesa mesa = mesaRepository.findById(idMesa).orElse(null);
        if (mesa == null) {
            mesa = new Mesa();
        }
        mesa.setNumero(dto.getNumero());
        Camarero camarero = camareroService.getById(idCamarero);
        mesa.setCamarero(camarero);
        return mesaRepository.save(mesa);
    }

    public Mesa guardar(MesaSaveDTO dto, Integer idCamarero) throws Exception {
        Mesa mesa = new Mesa();
        mesa.setNumero(dto.getNumero());
        Camarero camarero = camareroService.getById(idCamarero);
        mesa.setCamarero(camarero);
        return mesaRepository.save(mesa);
    }

    /**
     * elimina una mesa
     *
     * @param id
     */
    public void eliminar(Integer id) {
        mesaRepository.deleteById(id);
    }


}
