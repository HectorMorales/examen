package com.example.examen.service;



import com.example.examen.dto.EmpleadoDto;
import com.example.examen.entity.Departamento;
import com.example.examen.entity.Empleado;
import org.json.JSONArray;

import java.util.List;

public interface InterfaceEmpleadoService {

    public Empleado findId(long id);
    Empleado save(EmpleadoDto empleadoRequest);
    Empleado update(EmpleadoDto empleadoRequest);
    void delete(long id);
    JSONArray listAll();
}
