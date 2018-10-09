package py.com.rentacar.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import py.com.rentacar.controllers.MarcaController;

import py.com.rentacar.models.Marca;

@Path("/api/marcas")
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaService extends ResponseUtils{
	
	MarcaController controller = new MarcaController();

    @GET
    public String findAll() {
        List<Marca> marcaList;
        String json = null;
        try {
            marcaList = controller.getMarca();
            json = new Gson().toJson(marcaList); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    
    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Marca marca;
        String json = null;
        try {
         	marca = controller.getMarcaById(id);
            json = new Gson().toJson(marca);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @POST
    public Response create(Marca marca) {
        try {
            controller.createMarca(marca);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }
        
        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    public Response update(Marca marca, String id) {
        try {
            controller.updateMarca(marca, id);
        } catch (Exception e) {
            e.printStackTrace();
           Response.status(500).entity(STATUS500).build();
        }

       return Response.status(202).entity(STATUS201).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        try {
            controller.deleteMarca(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

       return Response.status(202).entity(STATUS202).build();
    }

}
