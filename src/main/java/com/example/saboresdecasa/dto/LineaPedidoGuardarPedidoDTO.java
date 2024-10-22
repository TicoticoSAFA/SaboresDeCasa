package com.example.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineaPedidoGuardarPedidoDTO {
    private Integer id;
    private Integer idProducto;
    private Integer idTipoProducto;
    private Integer cantidad;
}
