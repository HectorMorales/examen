package com.example.examen.repository;

import com.example.examen.entity.Empleado;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class EmpleadoRepository {

    @Inject
    EntityManager entityManager;

    public void create(Empleado empleado) {
        entityManager.persist(empleado);
    }

    public Empleado findById(Long id) {
        return entityManager.find(Empleado.class, id);
    }

    public void update(Empleado empleado) {
        entityManager.merge(empleado);
    }

    public void delete(long id) {
        entityManager.remove(entityManager.find(Empleado.class, id));
    }

    public List<Empleado> findAll() {
        List<Empleado> response = entityManager.createQuery("SELECT p FROM Empleado p", Empleado.class).getResultList();
        return  response;
    }


}
