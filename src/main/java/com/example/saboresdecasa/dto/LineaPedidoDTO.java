package com.example.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoDTO {
    private Integer cantidad;
    private ProductoDTO producto;
    private TipoProductoDTO tipoProducto;
    private PedidoDTO pedido;
}
