package chattanga.services;

import chattanga.classes.CAppVersion;
import chattanga.classes.CReservation;
import chattanga.dao.CCrudServiceBean;
import chattanga.dao.ICrudService;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static chattanga.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 31/08/16.
 */

@Path("/appversions")
@Produces("application/json")
@Consumes("application/json")
public class CAppVersionServices {

    public static ICrudService<CAppVersion> sCrudAppVersion = new CCrudServiceBean<CAppVersion>();


    //////// crud operations

    @GET
    @Produces("application/json")
    public static CAppVersion appVersion(){
        return (CAppVersion) sCrudAppVersion.findWithNamedQuery(CAppVersion.ACTUAL_APP_VERSION).get(0);
    }

    @PUT
    @Produces("application/json")
    public void putAppVersion(CAppVersion av){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudAppVersion.update(av);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postAppVersion(CAppVersion av) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudAppVersion.create(av);
        transac.commit();
    }
}
