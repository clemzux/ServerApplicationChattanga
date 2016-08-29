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
        @NamedQuery(name = CReservation.CRESERVATION_BY_ALL, query = "select reservation from CReservation reservation")
)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CReservation.class)
public class CReservation implements Serializable{

    @TableGenerator(name = "reservationGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "reservationGenerator")
    @Column(name = "reservation_id")
    private int id;
    private String name;
    private String tel;
    private int numberPeople;
    private int numberDayDish;
    private String note;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "date")
    private CDate date;

    public static final String CRESERVATION_BY_ALL = "CReservation.findReservationAll";


    //////// builder


    public CReservation () {}


    //////// methods


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }

    public int getNumberPeople() { return numberPeople; }

    public void setNumberPeople(int numberPeople) { this.numberPeople = numberPeople;}

    public int getNumberDayDish() { return numberDayDish; }

    public void setNumberDayDish(int numberDayDish) { this.numberDayDish = numberDayDish; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public CDate getDate() { return date; }

    public void setDate(CDate date) { this.date = date; }
}
