package chattanga.classes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clemzux on 03/08/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = CReservation.CRESERVATION_BY_ALL, query = "select reservation from CReservation reservation"),
        @NamedQuery(name = CReservation.CRESERVATION_BY_DATE, query =
                "select res from CReservation res, CDate d where res.date.id = d.id and d.date = :Pdate"),
        @NamedQuery(name = CReservation.CRESERVATION_BY_NAME, query =
                "select r.id, r.name, r.tel, r.numberDayDish, r.numberPeople, r.note from CReservation r where r.name = :Pname"),
        @NamedQuery(name = CReservation.CRESERVATION_BY_DATE_AND_NAME, query =
                "select res from CReservation res where res.name = :Pname and res.date.id = :Pdate")
})
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
    private String hourArrive;
    private String note;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "date")
    private CDate date;

    public static final String CRESERVATION_BY_ALL = "CReservation.findReservationAll";
    public static final String CRESERVATION_BY_DATE = "CReservation.findReservationByDate";
    public static final String CRESERVATION_BY_NAME = "CReservation.findReservationByNAme";
    public static final String CRESERVATION_BY_DATE_AND_NAME = "CReservation.findReservationByDateAndName";


    //////// builder


    public CReservation () {}


    //////// methods


    @Override
    public String toString() {
        return "CReservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", numberPeople=" + numberPeople +
                ", numberDayDish=" + numberDayDish +
                ", hourArrive='" + hourArrive + '\'' +
                ", note='" + note + '\'' +
                ", date=" + date +
                '}';
    }

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

    public String getHourArrive() { return hourArrive; }

    public void setHourArrive(String hourArrive) { this.hourArrive = hourArrive; }
}
