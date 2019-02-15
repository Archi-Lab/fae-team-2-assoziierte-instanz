package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class DementiellVeraendertePerson extends EntityUUID4{

    @Embedded
    private Vorname vorname;
    @Embedded
    private Nachname nachname;

    @ManyToMany(mappedBy = "dvps")
    private List<AssoziierteInstanz> asis;

    public Nachname getNachname() {
        return nachname;
    }

    public void setNachname(Nachname nachname) {
        this.nachname = nachname;
    }

    public Vorname getVorname() { return vorname; }

    public void setVorname(Vorname vorname) { this.vorname = vorname; }
}

