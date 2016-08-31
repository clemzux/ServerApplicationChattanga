package chattanga.services;

import chattanga.classes.CReservation;
import chattanga.dao.CCrudServiceBean;
import chattanga.dao.ICrudService;
import chattanga.classes.CDate;
import chattanga.dao.QueryParameter;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

import static chattanga.dao.CCrudServiceBean.em;
import static chattanga.services.CReservationServices.sCrudReservation;

/**
 * Created by clemzux on 03/08/16.
 */

@Path("/dates")
@Produces("application/json")
@Consumes("application/json")
public class CDateServices {

    public static ICrudService<CDate> sCrudDate = new CCrudServiceBean<CDate>();


    //////// crud operations


    // retourne toutes les dates
    @GET
    @Produces("application/json")
    public static List<CDate> dateAll(){
        return (List<CDate>) sCrudDate.findWithNamedQuery(CDate.CDATE_BY_ALL);
    }

    // retourne le plat du jour a une date donnée
    @GET
    @Produces("application/json")
    @Path("/date/{date}")
    public static CDate dateByDate(@PathParam("date") final String date) {
        return (CDate) sCrudDate.findWithNamedQuery(CDate.CDATE_BY_DATE,
                QueryParameter.with("Pdate", date).parameters()).get(0);
    }

    // retourne une réservation avec pour parametre la date et le nom
    @GET
    @Produces("application/json")
    @Path("/{date}/reservations/{name}")
    public static CReservation dateByDateAndName(@PathParam("date") final int pDate, @PathParam("name") final String pName) {
        return (CReservation) sCrudDate.findWithNamedQuery(CReservation.CRESERVATION_BY_DATE_AND_NAME,
                QueryParameter.with("Pdate", pDate).and("Pname", pName).parameters()).get(0);
    }

    // cette requete retourne toutes les réservations a une date donnée
    @GET
    @Produces("application/json")
    @Path("/{id}/reservations")
    public static List<CReservation> reservationByDate(@PathParam("id") final int pDate){
        return (List<CReservation>) sCrudReservation.findWithNamedQuery(
                CReservation.CRESERVATION_BY_DATE, QueryParameter.with("Pdate", pDate).parameters());
    }

    // cette requete retourne une date (plat du jour) avec son id
    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public static CDate dateById(@PathParam("id") final int pId) {
        return (CDate) sCrudDate.findWithNamedQuery(CDate.CDATE_BY_ID,
                QueryParameter.with("Pid", pId).parameters()).get(0);
    }

    @PUT
    @Produces("application/json")
    public void putDate(CDate date){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudDate.update(date);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postDate(CDate date) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudDate.create(date);
        transac.commit();
    }


    @DELETE
    @Path("/{id}")
    public void deleteDate(@PathParam("id") final int id ) {
        sCrudDate.delete(CDate.class, id);
    }
}
