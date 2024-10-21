package com.example.saboresdecasa.dto;

import com.example.saboresdecasa.models.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {
    private PedidoDTO pedido;
    List<CuentaLineaPedidoDTO> lineas;
}
