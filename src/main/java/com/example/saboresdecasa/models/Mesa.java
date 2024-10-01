package com.example.saboresdecasa.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="mesa", schema = "sabores_de_casa", catalog = "postgres")
@Getter
@Setter
@ToString(exclude = {"clientes", "camarero"})
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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "mesa_cliente", schema = "sabores_de_casa",
            joinColumns = {@JoinColumn(name = "id_mesa", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "id_cliente", nullable = false)}
    )
    private Set<Cliente> clientes = new HashSet<>(0);
}
