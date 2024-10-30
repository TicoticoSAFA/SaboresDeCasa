package com.example.saboresdecasa.repositorios;

import com.example.saboresdecasa.seguridad.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
