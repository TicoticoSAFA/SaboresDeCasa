package com.example.saboresdecasa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CamareroDTO {
    private Integer id;
    private String nombre;
    private String apellidos;
    private String mail;
}
