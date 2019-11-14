package at.htl.testexample.rest;

import at.htl.testexample.model.Speise;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("speise")
public class SpeiseEndpoint {

    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Speise> getAlleSpeisen() {
        return em.createNamedQuery("Speise.getAll", Speise.class).getResultList();
    }
}

