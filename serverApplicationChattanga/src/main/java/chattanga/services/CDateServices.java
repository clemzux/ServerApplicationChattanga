package chattanga.services;

import chattanga.dao.CCrudServiceBean;
import chattanga.dao.ICrudService;
import chattanga.classes.CDate;
import chattanga.dao.QueryParameter;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;
import java.util.Map;

import static chattanga.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 03/08/16.
 */

@Path("/dates")
@Produces("application/json")
@Consumes("application/json")
public class CDateServices {

    public static ICrudService<CDate> sCrudDate = new CCrudServiceBean<CDate>();


    //////// crud operations


    @GET
    @Produces("application/json")
    public static List<CDate> dateAll(){
        return (List<CDate>) sCrudDate.findWithNamedQuery(CDate.CDATE_BY_ALL);
    }

    @GET
    @Produces("application/json")
    @Path("/date/{date}")
    public static CDate dateByDate(@PathParam("date") final String date) {
        return (CDate) sCrudDate.findWithNamedQuery(CDate.CDATE_BY_DATE,
            QueryParameter.with("Pdate", date).parameters()).get(0);
    }

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
