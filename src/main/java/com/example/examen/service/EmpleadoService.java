package com.example.examen.service;

import com.example.examen.dto.EmpleadoDto;
import com.example.examen.entity.Empleado;
import com.example.examen.repository.DepartamentoRepository;
import com.example.examen.repository.EmpleadoRepository;
import jakarta.inject.Inject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;

public class EmpleadoService implements InterfaceEmpleadoService{

    @Inject
    EmpleadoRepository repositoryEmpleado;

    @Inject
    DepartamentoRepository repositoryDepartamento;

    public Empleado findId(long id){
        Empleado empleado = repositoryEmpleado.findById(id);
        Empleado empleadoReponse = new Empleado();
        if(empleado != null){
            empleadoReponse.setId(empleado.getId());
            empleadoReponse.setNombre(empleado.getNombre());
            empleadoReponse.setPaterno(empleado.getPaterno());
            empleadoReponse.setMaterno(empleado.getMaterno());
            empleadoReponse.setDepartamento_id(repositoryDepartamento.findById(empleado.getDepartamento_id().getId()));
            empleadoReponse.setFecha_ingreso(empleado.getFecha_ingreso());
            empleadoReponse.setManager_id(empleado.getManager_id());
            return empleadoReponse;
        }else {
            return null;
        }
    }

    @Override
    public Empleado save(EmpleadoDto empleadoRequest) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setPaterno(empleadoRequest.getPaterno());
        empleado.setMaterno(empleadoRequest.getMaterno());
        empleado.setDepartamento_id(repositoryDepartamento.findById(empleadoRequest.getDepartamento_id()));
        empleado.setFecha_ingreso(new Date());
        empleado.setManager_id(empleadoRequest.getManager_id());
        repositoryEmpleado.create(empleado);
        return empleado;
    }

    @Override
    public Empleado update(EmpleadoDto empleadoRequest) {
        Empleado empleado = new Empleado();
        empleado.setId(empleadoRequest.getId());
        empleado.setNombre(empleadoRequest.getNombre());
        empleado.setPaterno(empleadoRequest.getPaterno());
        empleado.setMaterno(empleadoRequest.getMaterno());
        empleado.setDepartamento_id(repositoryDepartamento.findById(empleadoRequest.getDepartamento_id()));
        empleado.setFecha_ingreso(new Date());
        empleado.setManager_id(empleadoRequest.getManager_id());
        repositoryEmpleado.update(empleado);
        return empleado;
    }

    @Override
    public void delete(long id) {
        repositoryEmpleado.delete(id);
    }

    @Override
    public JSONArray listAll() {

        List<Empleado> empleadosResponse = repositoryEmpleado.findAll();

        JSONArray responsearray = new JSONArray();
        for(Empleado mpd : empleadosResponse)
        {
            JSONObject departamento = new JSONObject();
            departamento.put("clave",mpd.getDepartamento_id().getClave());
            departamento.put("id",mpd.getDepartamento_id().getId());
            departamento.put("nombre_departamento",mpd.getDepartamento_id().getNombre_departamento());
            JSONObject empleado = new JSONObject();
            empleado.put("departamento_id",departamento);
            empleado.put("id",mpd.getId());
            empleado.put("manager_id",mpd.getManager_id());
            empleado.put("materno",mpd.getMaterno());
            empleado.put("nombre",mpd.getNombre());
            empleado.put("paterno",mpd.getNombre());
            empleado.put("fecha_ingreso",mpd.getFecha_ingreso());
            responsearray.put(empleado);
        }

        return responsearray;
    }
}
