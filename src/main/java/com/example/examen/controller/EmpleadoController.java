package com.example.examen.controller;


import com.example.examen.dto.EmpleadoDto;
import com.example.examen.entity.Empleado;
import com.example.examen.service.EmpleadoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.json.JSONArray;


@Path("/empleado")
public class EmpleadoController {

    @Inject
    private EmpleadoService empleadoService;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response findId(@PathParam("id") long id) {
        Empleado empleadoResponse = empleadoService.findId(id);
        if (empleadoResponse != null) {
            return Response.ok().status(Response.Status.OK).entity(empleadoResponse).build();
        }else{
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Produces("application/json")
    public Response findAll() {
        JSONArray empleadosResponse = empleadoService.listAll();
        return Response.ok().status(Response.Status.OK).entity(empleadosResponse.toString()).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response create(EmpleadoDto empleadoRequest) {
        Empleado empleadoResponse = empleadoService.save(empleadoRequest);
        return Response.ok().status(Response.Status.OK).entity(empleadoResponse).build();
    }

    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(EmpleadoDto empleadoRequest) {
        Empleado empleado = empleadoService.findId(empleadoRequest.getId());
        if (empleado != null) {
            Empleado empleadoResponse = empleadoService.update(empleadoRequest);
            return Response.ok().status(Response.Status.CREATED).entity(empleadoResponse).build();
        }else{
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") long id) {
        Empleado empleado = empleadoService.findId(id);
        if (empleado != null) {
            empleadoService.delete(id);
            return Response.ok().status(Response.Status.OK).build();
        }else{
            return Response.ok().status(Response.Status.NOT_FOUND).build();
        }
    }

}
