import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "school")
public class School implements Serializable {

    @Id
    @Column(name = "id_school")
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_district")
    private District district;

    public School() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
