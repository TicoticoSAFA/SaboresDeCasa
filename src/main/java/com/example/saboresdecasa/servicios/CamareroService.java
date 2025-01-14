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
    public Camarero getById(Integer id) throws Exception {
        Camarero camarero = camareroRepository.findById(id).orElse(null);
        if (camarero == null) {
            throw new Exception("No existe ningún camarero con el id indicado");
        } else {
            return camarero;
        }
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
        try {
            if (camarero.getNombre().isBlank()) {
                throw new Exception("El nombre debe estar relleno");
            } else if (camarero.getApellidos().isBlank()) {
                throw new Exception("Los apellidos deben estar rellenos");
            } else if (camarero.getDni().isBlank()) {
                throw new Exception("El dni debe estar relleno");
            } else if (camarero.getEmail().isBlank()) {
                throw new Exception("El email debe estar relleno");
            }
            return camareroRepository.save(camarero);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * elimina un camarero por id
     *
     * @param id
     */
    public String eliminar(Integer id) throws Exception {
        try {
            camareroRepository.deleteById(id);
           return "Se ha eliminado el camarero";
        }catch (Exception e){
            throw new Exception("No existe ningún camarero con el id indicado");
        }
    }


}
