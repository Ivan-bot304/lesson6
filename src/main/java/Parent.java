import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Parent")
public class Parent  implements Serializable {

    @Id
    @Column(name = "id_parent")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    public Set<Child> getChildren() {
        return children;
    }

    public void setChildren(Child children) {
        this.children.add(children);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_parent_child",
            joinColumns = @JoinColumn(name = "id_parent"),
            inverseJoinColumns = @JoinColumn(name = "id_child"))
    private Set<Child> children = new HashSet<Child>();

    @ManyToOne(cascade = CascadeType.MERGE)
   @JoinColumn(name = "id_district")
    private District district;



    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parent(String name) {
        this.name = name;
    }

    public Parent() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
