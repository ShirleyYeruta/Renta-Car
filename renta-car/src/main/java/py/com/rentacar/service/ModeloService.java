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

import py.com.rentacar.controllers.ModeloController;
import py.com.rentacar.models.Modelo;



@Path("/api/modelos")
@Consumes(MediaType.APPLICATION_JSON)

public class ModeloService extends ResponseUtils{
	ModeloController controller = new ModeloController();

    @GET
    public String findAll() {
        List<Modelo> modeloList;
        String json = null;
        try {
            modeloList = controller.getModelo();
            json = new Gson().toJson(modeloList); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    
    @GET
    @Path("/{id}")
    public String findById(@PathParam("id") String id) {
        Modelo modelo;
        String json = null;
        try {
         	modelo = controller.getModeloById(id);
            json = new Gson().toJson(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @POST
    public Response create(Modelo modelo) {
        try {
            controller.createModelo(modelo);
        } catch (Exception e) {
            e.printStackTrace();
            Response.serverError().build();
        }
        
        return Response.status(201).entity(STATUS201).build();
    }

    @PUT
    public Response update(Modelo modelo, String id) {
        try {
            controller.updateModelo(modelo, id);
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
            controller.deleteModelo(id);
        } catch (Exception e) {
            e.printStackTrace();
            Response.status(500).entity(STATUS500).build();
        }

       return Response.status(202).entity(STATUS202).build();
    }

}
