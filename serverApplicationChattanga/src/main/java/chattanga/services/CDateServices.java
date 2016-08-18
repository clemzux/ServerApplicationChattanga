package chattanga.services;

import chattanga.dao.CCrudServiceBean;
import chattanga.dao.ICrudService;
import chattanga.classes.CDate;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

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
