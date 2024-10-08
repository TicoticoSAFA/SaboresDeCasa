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

    /**
     * devuelve todas las mesas
     *
     * @return
     */
    public List<MesaDTO> getAll() {
        List<Mesa> mesasList = mesaRepository.findAll();
        List<MesaDTO> mesaDTOList = new ArrayList<>();
        for (Mesa m : mesasList) {
            MesaDTO dto = new MesaDTO();
            dto.setNumero(m.getNumero());

            CamareroDTO camareroDTO = new CamareroDTO();
            Camarero camarero = m.getCamarero();
            camareroDTO.setNombre(camarero.getNombre());
            camareroDTO.setApellidos(camarero.getApellidos());
            camareroDTO.setMail(camarero.getEmail());
            dto.setCamarero(camareroDTO);

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
        MesaDTO dto = new MesaDTO();
        dto.setNumero(mesa.getNumero());

        Camarero camarero = mesa.getCamarero();
        CamareroDTO camareroDTO = new CamareroDTO();
        camareroDTO.setNombre(camarero.getNombre());
        camareroDTO.setApellidos(camarero.getApellidos());
        camareroDTO.setMail(camarero.getEmail());
        dto.setCamarero(camareroDTO);

        return dto;
    }

    /**
     * crea o modifica una mesa
     *
     * @param mesa
     * @return
     */
    public Mesa guardar(Mesa mesa) {
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
