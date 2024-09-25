package com.example.saboresdecasa.models;

import com.example.saboresdecasa.Enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.Enumerates.TipoTipoProducto;
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
    @Enumerated(EnumType.ORDINAL)
    private TipoTipoProducto tipo;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "tamanyo", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private TamanyoTipoProducto tamanyo;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
