package br.resource;

import br.dto.RequestConsoleDTO;
import br.model.Console;
import br.service.ConsoleService;
import br.service.exception.ConsoleNotFoundException;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("api/console")
public class ConsoleResource {

    private final ConsoleService service;

    @Inject
    public ConsoleResource(ConsoleService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConsoleList() {
        final List<Console> response = service.findAllConsoles();
        return Response
                .ok(response)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertConsole(@NotNull RequestConsoleDTO dto) {
        final Console response = service.insert(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findConsoleById(@PathParam("id") long id) {
        try {
            final Console response = service.findConsoleById(id);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ConsoleNotFoundException ex) {
            return Response.status(Response.Status.NOT_FOUND).entity(ex.getMessage()).build();
        }
    }

    /*@PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateConsole(@PathParam("id") long id, @NotNull RequestConsoleDTO dto) {
        try {
            final Console response = service.updateConsole(id, dto);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ConsoleNotFoundException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
    }

    
    
    @DELETE
    @Path("/{id}")
    public void removeConsoleById(@PathParam("id") long id){
        service.removeConsoleById(id);
    }*/
}
