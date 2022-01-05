package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.BoatDTO;
import facades.BoatFacade;
import facades.OwnerFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("boat")
public class BoatRessource {


        private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

        private static final BoatFacade FACADE =  BoatFacade.getFacadeExample(EMF);
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

        @GET
        @Produces({MediaType.APPLICATION_JSON})
        public String demo() {
            return "{\"msg\":\"Hello World\"}";
        }

    @GET
    @Path("getBoatByHarbour/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getBoatByHarbour(@PathParam("name") String name) {
        List<BoatDTO> rn = FACADE.getBoatByHarbour(name);
        return Response.ok().entity(GSON.toJson(rn)).build();
    }


}
