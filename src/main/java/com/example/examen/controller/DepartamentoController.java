package com.example.examen.controller;

import com.example.examen.dto.DepartamentoDto;
import com.example.examen.entity.Departamento;
import com.example.examen.service.DepartamentoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/departamento")
public class DepartamentoController {

    @Inject
    private DepartamentoService departamentoService;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findId(@PathParam("id") long id) {
        Departamento departamentoResponse = departamentoService.findId(id);
        if (departamentoResponse != null) {
            return Response.ok().status(Response.Status.OK).entity(departamentoResponse).build();
        }else{
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }

    }

    @GET
    @Produces("application/json")
    public Response findAll() {
        List<Departamento> departamentosResponse = departamentoService.listAll();
        return Response.ok().status(Response.Status.OK).entity(departamentosResponse).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response create(DepartamentoDto departamentoRequest) {
        Departamento departamentoResponse = departamentoService.save(departamentoRequest);
        return Response.ok().status(Response.Status.OK).entity(departamentoResponse).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(DepartamentoDto departamentoRequest) {
        Departamento departamento = departamentoService.findId(departamentoRequest.getId());
        if (departamento != null) {
            Departamento departamentoResponse = departamentoService.update(departamentoRequest);
            return Response.ok().status(Response.Status.CREATED).entity(departamentoResponse).build();
        }else{
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }

    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        Departamento departamento = departamentoService.findId(id);
        if (departamento != null) {
            departamentoService.delete(id);
            return Response.ok().status(Response.Status.OK).build();
        }else{
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }

}
