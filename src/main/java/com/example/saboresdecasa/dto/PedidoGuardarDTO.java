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
    private Double total;
    private String fecha;
    private Integer idMesa;
    private List<LineaPedidoPedidoDTO> lineasPedido;
}
