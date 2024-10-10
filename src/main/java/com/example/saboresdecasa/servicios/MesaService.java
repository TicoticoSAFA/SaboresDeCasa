package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.dto.CamareroDTO;
import com.example.saboresdecasa.dto.MesaDTO;
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
        dto.setId(mesa.getId());
        dto.setNumero(mesa.getNumero());

        Camarero camarero = mesa.getCamarero();
        CamareroDTO camareroDTO = new CamareroDTO();
        camareroDTO.setId(camarero.getId());
        camareroDTO.setNombre(camarero.getNombre());
        camareroDTO.setApellidos(camarero.getApellidos());
        camareroDTO.setMail(camarero.getEmail());
        camareroDTO.setDni(camarero.getDni());
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

    /**
     * crea o modifica una mesa
     *
     * @param dto
     * @return
     */
    public Mesa guardar(MesaDTO dto) {
        Mesa mesaEntity = new Mesa();

        mesaEntity.setNumero(dto.getNumero());

        Camarero camareroEntity = new Camarero();
        CamareroDTO camareroDTO = dto.getCamarero();

        camareroEntity.setId(camareroDTO.getId());
        camareroEntity.setNombre(camareroDTO.getNombre());
        camareroEntity.setApellidos(camareroDTO.getApellidos());
        camareroEntity.setEmail(camareroDTO.getMail());
        camareroEntity.setDni(camareroDTO.getDni());

        mesaEntity.setCamarero(camareroEntity);
        return mesaEntity;
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
