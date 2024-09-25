package com.example.saboresdecasa.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pedido", schema = "Sabores_de_casa", catalog = "postgres")
@Getter
@Setter
@ToString(exclude = {"mesa"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private Mesa mesa;
}
