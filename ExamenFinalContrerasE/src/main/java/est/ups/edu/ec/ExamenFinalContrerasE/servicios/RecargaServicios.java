package est.ups.edu.ec.ExamenFinalContrerasE.servicios;



import est.ups.edu.ec.ExamenFinalContrerasE.model.Recarga;
import java.util.List;

import est.ups.edu.ec.ExamenFinalContrerasE.bussines.GestionRecarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargaServicios {

    @Inject
    private GestionRecarga gestionRecarga;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Recarga recarga) {
        try {
            gestionRecarga.guardarRecarga(recarga);
            ErrorMessage error = new ErrorMessage(1, "OK");
            return Response.status(Response.Status.CREATED)
                    .entity(error)
                    .build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Recarga recarga) {
        try {
            gestionRecarga.actualizarRecarga(recarga);
            return Response.ok(recarga).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrar(@QueryParam("id") int id) {
        try {
            gestionRecarga.borrarRecarga(id);
            return Response.ok("OK").build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(error)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response leerPorId(@QueryParam("id") int id) {
        try {
            Recarga recarga = gestionRecarga.getRecargaPorId(id);
            return Response.ok(recarga).build();
        } catch (Exception e) {
            ErrorMessage error = new ErrorMessage(4, "Recarga no existe");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public Response obtenerRecargas() {
        List<Recarga> recargas = gestionRecarga.getRecargas();
        if (!recargas.isEmpty()) {
            return Response.ok(recargas).build();
        } else {
            ErrorMessage error = new ErrorMessage(6, "No se registran recargas");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(error)
                    .build();
        }
    }
}


