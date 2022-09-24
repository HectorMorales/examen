package com.example.examen.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Empleado implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 80, nullable = false)
    private String nombre;

    @Column(name = "paterno", length = 80, nullable = false)
    private String paterno;

    @Column(name = "materno", length = 80, nullable = false)
    private String materno;

    @Column(name = "fecha_ingreso", nullable = false)
    private Date fecha_ingreso;

    @Column(name = "manager_id", nullable = false)
    private Integer manager_id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn( referencedColumnName = "id", nullable = false)
    private Departamento departamento_id;


}
