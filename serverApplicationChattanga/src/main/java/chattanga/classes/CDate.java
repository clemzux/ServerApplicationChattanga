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
        @NamedQuery(name = CDate.CDATE_BY_ALL, query = "select date from CDate date order by date.date"),
        @NamedQuery(name = CDate.CDATE_BY_DATE, query = "select date from CDate date where date.date = :Pdate"),
        @NamedQuery(name = CDate.CDATE_BY_ID, query = "select date from CDate date where date.id = :Pid")
})
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CDate.class)
public class CDate implements Serializable{

    @TableGenerator(name = "dateGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dateGenerator")
    @Column(name = "date_id")
    private int id;
    private String date;
    private String dayDish;
    private String imageIdentifier;

    public static final String CDATE_BY_ALL = "CDate.findDateAll";
    public static final String CDATE_BY_DATE = "CDate.findDateByDate";
    public static final String CDATE_BY_ID = "CDate.finDateByID";


    //////// builder


    public CDate () {}


    //////// methods


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getDayDish() { return dayDish; }

    public void setDayDish(String dayDish) { this.dayDish = dayDish; }

    public String getImageIdentifier() { return imageIdentifier; }

    public void setImageIdentifier(String imageIdentifier) { this.imageIdentifier = imageIdentifier; }

    @Override
    public String toString() {
        return "CDate{" +
                "id=" + id +
                ", dayDish='" + dayDish + '\'' +
                '}';
    }
}
