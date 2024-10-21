package com.example.saboresdecasa.dto;

import com.example.saboresdecasa.models.TipoProducto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaLineaPedidoDTO {
    private Integer id;
    private Integer cantidad;
    private TipoProducto tipoProducto;
}
