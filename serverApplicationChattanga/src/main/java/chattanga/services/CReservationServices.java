package chattanga.services;

import chattanga.dao.CCrudServiceBean;
import chattanga.dao.ICrudService;
import chattanga.classes.CReservation;
import chattanga.dao.QueryParameter;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static chattanga.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 03/08/16.
 */

@Path("/reservations")
@Produces("application/json")
@Consumes("application/json")
public class CReservationServices {

    public static ICrudService<CReservation> sCrudReservation = new CCrudServiceBean<CReservation>();


    //////// crud operations


    @GET
    @Produces("application/json")
    public static List<CReservation> reservationAll(){
        return (List<CReservation>) sCrudReservation.findWithNamedQuery(CReservation.CRESERVATION_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putReservation(CReservation cReservation){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudReservation.update(cReservation);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postReservation(CReservation cReservation) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudReservation.create(cReservation);
        transac.commit();
    }


    @DELETE
    @Path("/{id}")
    public void deleteReservation(@PathParam("id") final int id ) {
        sCrudReservation.delete(CReservation.class, id);
    }
}
