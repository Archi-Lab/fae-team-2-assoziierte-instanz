package fae.dvp.bezugsperson.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraendertePerson {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
//    @Embedded
//    private Vorname vorname;

    /**@OneToMany(mappedBy = "dvp",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DvpAsi> dvpAsis;**/

    @ManyToMany(mappedBy = "dvps")
    private List<AssoziierteInstanz> asis;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


//    public Vorname getVorname() { return vorname; }
//
//    public void setVorname(Vorname vorname) { this.vorname = vorname; }
}

