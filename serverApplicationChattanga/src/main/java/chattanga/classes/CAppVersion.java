package chattanga.classes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clemzux on 31/08/16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = CAppVersion.ACTUAL_APP_VERSION, query = "select appVersion from CAppVersion appVersion")
})
public class CAppVersion implements Serializable {

    @TableGenerator(name = "appVersionGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "appVersionGenerator")
    @Column(name = "appVersion_id")
    private int id;
    private int versionNumber;

    public static final String ACTUAL_APP_VERSION = "CAppVersion.findActualVersion";


    //////// builder


    public CAppVersion () {}


    //////// methods


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }
}
