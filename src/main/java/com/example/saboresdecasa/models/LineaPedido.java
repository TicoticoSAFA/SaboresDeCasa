package com.example.saboresdecasa.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="linea_pedido", schema = "sabores_de_casa", catalog = "postgres")
@Getter
@Setter
@ToString(exclude = {"producto", "tipoProducto", "pedido"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LineaPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;

    @ManyToOne (cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
