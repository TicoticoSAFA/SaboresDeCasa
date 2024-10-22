package com.example.saboresdecasa.dto;

import com.example.saboresdecasa.models.LineaPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoGuardarDTO {
    private Integer idMesa;
    private Integer idCliente;
    private List<LineaPedidoGuardarPedidoDTO> lineasPedido;
}
