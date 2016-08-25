package chattanga.server;

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

        CDate cDate = new CDate();
        cDate.setId(1);
        cDate.setDate("04/09/2016");
        cDate.setDayDish("poulet frites");

//        webResource.path("dates").type(MediaType.APPLICATION_JSON).post(cDate);

        CReservation cReservation = new CReservation();
//        cReservation.setId(1);
        cReservation.setDate(cDate);
        cReservation.setName("clement farge");
        cReservation.setNote("Bord de piste au bar !!!!");
        cReservation.setNumber(2);
        cReservation.setTel("0689627293");

        webResource.path("reservations").type(MediaType.APPLICATION_JSON).post(cReservation);
    }
}
