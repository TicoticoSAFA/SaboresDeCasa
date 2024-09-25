package com.example.saboresdecasa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="camarero", schema = "Sabores_de_casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Camarero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "email", nullable = false)
    private String email;
}
