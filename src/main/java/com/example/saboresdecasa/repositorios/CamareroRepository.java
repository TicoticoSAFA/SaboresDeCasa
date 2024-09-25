package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.Camarero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CamareroRepository extends JpaRepository<Camarero, Integer> {

}
