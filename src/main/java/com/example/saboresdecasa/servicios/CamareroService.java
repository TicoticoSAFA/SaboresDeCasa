package com.example.saboresdecasa.servicios;

import com.example.saboresdecasa.models.Camarero;
import com.example.saboresdecasa.repositorios.CamareroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CamareroService {

    private CamareroRepository camareroRepository;


    /**
     * Busca camareros por nombre
     *
     * @param nombre
     * @return
     */
    public List<Camarero> getCamareroPorNombre(String nombre) {
        List<Camarero> camareros = camareroRepository.findAllByNombreEquals(nombre);
        return camareros;
    }

    /**
     * busca camareros por id
     *
     * @param id
     * @return
     */
    public Camarero getById(Integer id) {
        return camareroRepository.findById(id).orElse(null);
    }

    /**
     * devuelve todos los camareros
     *
     * @return
     */

    public List<Camarero> getAll() {
        return camareroRepository.findAll();
    }

    /**
     * crea o modifica un camarero
     *
     * @param camarero
     * @return
     */
    public Camarero guardar(Camarero camarero) {
        return camareroRepository.save(camarero);
    }

    /**
     * elimina un camarero por id
     *
     * @param id
     */
    public String eliminar(Integer id) {
        Camarero camarero = camareroRepository.getById(id);
        if (camarero != null){
            return "no hay perfil";
        }
        try {
            camareroRepository.deleteById(id);
            camarero = camareroRepository.getById(id);
            if (camarero != null){
                return "no se ha podido eliminar el perfil";
            }else {
                return "perfil eliminado perfectamente";
            }
        }catch (Exception e){
            return "No se ha eliminado el perfil";
        }
    }


}
