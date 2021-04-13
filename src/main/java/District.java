import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "district")
public class District implements Serializable {

    public District() {
    }

    public District(String name) {
        this.name = name;
    }


    @Id
    @Column(name = "id_district")
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    public int getId() {
        return id;
    }

    /*@OneToOne(mappedBy = "district", cascade = CascadeType.ALL)
    public Set<Parent> parents = new HashSet<Parent>();

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Set<Parent> parents) {
        this.parents = parents;
    }*/

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
