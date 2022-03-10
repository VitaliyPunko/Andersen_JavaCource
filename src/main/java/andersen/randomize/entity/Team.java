package andersen.randomize.entity;

import javax.persistence.*;
import java.util.List;

@Table(name = "team")
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    @OneToMany(mappedBy = "team",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Student> students;


    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                '}';
    }
}
