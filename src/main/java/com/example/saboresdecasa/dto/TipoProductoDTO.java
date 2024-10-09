package com.example.saboresdecasa.dto;

import com.example.saboresdecasa.enumerates.TamanyoTipoProducto;
import com.example.saboresdecasa.enumerates.TipoTipoProducto;
import com.example.saboresdecasa.models.Producto;
import com.example.saboresdecasa.models.TipoProducto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProductoDTO {
    private Integer id;
    private TipoTipoProducto tipo;
    private Double precio;
    private TamanyoTipoProducto tamanyo;
    private ProductoDTO producto;

}
