package com.example.examen.service;

import com.example.examen.dto.DepartamentoDto;
import com.example.examen.entity.Departamento;

import java.util.List;

public interface InterfaceDepartamentoService {

    public Departamento findId(long id);
    Departamento save(DepartamentoDto departamentoRequest);
    Departamento update(DepartamentoDto departamentoRequest);
    void delete(long id);
    List<Departamento> listAll();

}
