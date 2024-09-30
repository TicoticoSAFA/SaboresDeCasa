package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.Mesa;
import com.example.saboresdecasa.repositorios.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MesaService {

    private MesaRepository mesaRepository;

    /**
     * devuelve todas las mesas
     *
     * @return
     */
    public List<Mesa> getAll() {
        return mesaRepository.findAll();
    }

    /**
     * busca mesa por id
     *
     * @param id
     * @return
     */
    public Mesa getbyId(Integer id) {
        return mesaRepository.findById(id).orElse(null);
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
