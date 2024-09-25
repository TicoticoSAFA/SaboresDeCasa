package com.example.saboresdecasa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tipo_producto", schema = "Sabores_de_casa", catalog = "postgres")
@Getter
@Setter
@ToString(exclude = {"producto"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TipoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "tamanyo", nullable = false)
    private String tamanyo;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
