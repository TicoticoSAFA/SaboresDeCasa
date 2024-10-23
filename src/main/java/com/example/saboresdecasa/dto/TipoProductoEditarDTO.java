package com.example.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProductoEditarDTO {
    private Integer idProducto;
    private String tipo;
    private Double precio;
}
