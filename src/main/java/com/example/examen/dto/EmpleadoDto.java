package com.example.examen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoDto {

    private Long id;
    private String nombre;
    private String paterno;
    private String materno;
    private Integer manager_id;
    private Long departamento_id;
}
