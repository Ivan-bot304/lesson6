import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "child")
public class Child implements Serializable {

    @Id
    @Column(name = "id_child")
    @GeneratedValue
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "join_parent_child",
            joinColumns = @JoinColumn(name = "id_child"),
            inverseJoinColumns = @JoinColumn(name = "id_parent"))
    private Set<Parent> parents = new HashSet<Parent>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_school")
    private School school;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Child(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Child() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public void setParents(Parent parent) {
        this.parents.add(parent);
    }
}
