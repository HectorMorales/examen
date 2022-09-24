package com.example.examen.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDto {

    private Long id;
    private String clave;
    private String nombre_departamento;



}
