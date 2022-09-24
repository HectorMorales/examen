package com.example.examen.repository;

import com.example.examen.entity.Departamento;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class DepartamentoRepository {

    @Inject
    EntityManager entityManager;

    public void create(Departamento departamento) {
        entityManager.persist(departamento);
    }

    public Departamento findById(Long id) {
        return entityManager.find(Departamento.class, id);
    }

    public void update(Departamento departamento) {
        entityManager.merge(departamento);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.find(Departamento.class, id));
    }

    public List<Departamento> findAll() {
        return entityManager.createQuery("SELECT d FROM Departamento d", Departamento.class).getResultList();
    }
}
