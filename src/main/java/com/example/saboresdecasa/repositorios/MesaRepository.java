package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa,Integer> {

}
