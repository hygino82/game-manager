package br.resource;

import br.model.Console;
import br.service.ConsoleService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
}
