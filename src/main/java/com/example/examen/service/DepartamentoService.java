package com.example.examen.service;

import com.example.examen.dto.DepartamentoDto;
import com.example.examen.entity.Departamento;
import com.example.examen.repository.DepartamentoRepository;
import jakarta.inject.Inject;

import java.util.List;

public class DepartamentoService implements InterfaceDepartamentoService {

    @Inject
    DepartamentoRepository repositoryDepartamento;

    @Override
    public Departamento findId(long id) {
        return repositoryDepartamento.findById(id);
    }

    @Override
    public Departamento save(DepartamentoDto departamentoRequest) {
        Departamento departamento = new Departamento();
        departamento.setClave(departamentoRequest.getClave());
        departamento.setNombre_departamento(departamentoRequest.getNombre_departamento());
        repositoryDepartamento.create(departamento);
        return departamento;
    }

    @Override
    public Departamento update(DepartamentoDto departamentoRequest) {
        Departamento departamento = new Departamento();
        departamento.setId(departamentoRequest.getId());
        departamento.setClave(departamentoRequest.getClave());
        departamento.setNombre_departamento(departamentoRequest.getNombre_departamento());
        repositoryDepartamento.update(departamento);
        return departamento;
    }

    @Override
    public void delete(long id) {
        repositoryDepartamento.delete(id);
    }

    @Override
    public List<Departamento> listAll() {
        return repositoryDepartamento.findAll();
    }
}
