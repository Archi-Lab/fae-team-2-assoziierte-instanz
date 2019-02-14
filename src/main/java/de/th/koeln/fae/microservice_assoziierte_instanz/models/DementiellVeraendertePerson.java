package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraendertePerson {

    @Id
    private String id;
    @Embedded
    private Vorname vorname;
    @Embedded
    private Nachname nachname;

    /**@OneToMany(mappedBy = "dvp",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DvpAsi> dvpAsis;**/

    @ManyToMany(mappedBy = "dvps")
    private List<AssoziierteInstanz> asis;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Nachname getNachname() {
        return nachname;
    }

    public void setNachname(Nachname nachname) {
        this.nachname = nachname;
    }

    public Vorname getVorname() { return vorname; }

    public void setVorname(Vorname vorname) { this.vorname = vorname; }
}

