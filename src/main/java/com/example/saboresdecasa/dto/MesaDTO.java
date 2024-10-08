package com.example.saboresdecasa.dto;

import com.example.saboresdecasa.models.Camarero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesaDTO {
        private Integer numero;
        private CamareroDTO camarero;
}
