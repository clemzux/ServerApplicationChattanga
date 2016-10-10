package chattanga.server;

import chattanga.classes.CAppVersion;
import chattanga.classes.CDate;
import chattanga.classes.CReservation;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;

/**
 * Created by clemzux on 03/08/16.
 */
public class CServerTestQuery {

    public static void main(String[] args) {

        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        WebResource webResource = c.resource("http://localhost:9999/");

        CDate cDate1 = new CDate();
        cDate1.setId(1);
        cDate1.setDate("21-09-2016");
        cDate1.setDayDish("poulet frites et sauce gras");
        cDate1.setImageIdentifier("pouletfrites");

        CDate cDate2 = new CDate();
        cDate2.setId(2);
        cDate2.setDate("22-09-2016");
        cDate2.setDayDish("60 cm hot dog et sa sauce moutarde");
        cDate2.setImageIdentifier("hotdog");

        CDate cDate3 = new CDate();
        cDate3.setId(3);
        cDate3.setDate("23-09-2016");
        cDate3.setDayDish("1m pizza fond tomate, et ses petits oignons crus");
        cDate3.setImageIdentifier("pizza");

        webResource.path("dates").type(MediaType.APPLICATION_JSON).post(cDate1);
        webResource.path("dates").type(MediaType.APPLICATION_JSON).post(cDate2);
        webResource.path("dates").type(MediaType.APPLICATION_JSON).post(cDate3);

        CAppVersion av = new CAppVersion();
        av.setId(1);
        av.setVersionNumber(1);

        webResource.path("appversions").type(MediaType.APPLICATION_JSON).post(av);

//        CReservation cReservation = new CReservation();
//        cReservation.setId(1);
//        cReservation.setDate(cDate1);
//        cReservation.setName("clement farge");
//        cReservation.setNote("Bord de piste au bar !!!!");
//        cReservation.setNumber(2);
//        cReservation.setTel("0689627293");
//
//        webResource.path("reservations").type(MediaType.APPLICATION_JSON).post(cReservation);
    }
}
