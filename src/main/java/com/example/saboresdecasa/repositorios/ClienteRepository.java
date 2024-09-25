package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}

