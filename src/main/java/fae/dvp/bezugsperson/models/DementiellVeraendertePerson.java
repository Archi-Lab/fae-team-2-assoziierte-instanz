package fae.dvp.bezugsperson.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraendertePerson {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "dvp",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DvpAsi> dvpAsis;

    @ManyToMany(mappedBy = "dvps")
    private List<AssoziierteInstanz> asis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
