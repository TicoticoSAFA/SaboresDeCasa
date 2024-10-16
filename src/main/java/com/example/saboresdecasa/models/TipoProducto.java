package com.example.saboresdecasa.models;

import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tipo_producto", schema = "sabores_de_casa", catalog = "postgres")
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

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto")
    private Producto producto;
}
