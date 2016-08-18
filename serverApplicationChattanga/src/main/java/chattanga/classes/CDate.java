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
        @NamedQuery(name = CDate.CDATE_BY_ALL, query = "select date from CDate date")
)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = CDate.class)
public class CDate implements Serializable{

    @TableGenerator(name = "dateGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dateGenerator")
    @Column(name = "date_id")
    private int id;
    private String dayDish;

    public static final String CDATE_BY_ALL = "CDate.findDateAll";


    //////// builder


    public CDate () {}


    //////// methods


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDayDish() { return dayDish; }

    public void setDayDish(String dayDish) { this.dayDish = dayDish; }

    @Override
    public String toString() {
        return "CDate{" +
                "id=" + id +
                ", dayDish='" + dayDish + '\'' +
                '}';
    }
}
