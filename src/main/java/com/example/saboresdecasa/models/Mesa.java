package com.example.saboresdecasa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="mesa", schema = "Sabores_de_casa", catalog = "postgres")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_camarero")
    private Camarero camarero;
}
