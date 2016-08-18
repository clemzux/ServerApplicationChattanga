package chattanga.classes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clemzux on 03/08/16.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CReservation.CRESERVATION_BY_ALL, query = "select date from CReservation date")
)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CDate.class)
public class CReservation implements Serializable{

    @TableGenerator(name = "reservationGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "reservationGenerator")
    @Column(name = "reservation_id")
    private int id;
    private String name;
    private String tel;
    private int number;
    private String note;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "date")
    private CDate date;

    public static final String CRESERVATION_BY_ALL = "CReservation.findReservationAll";


    //////// builder


    public CReservation () {}


    //////// methods
}
