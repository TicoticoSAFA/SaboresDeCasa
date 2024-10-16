package com.example.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoPedidoDTO {
    private Integer id;
    private Integer cantidad;
    private Integer idTipoProducto;
}
