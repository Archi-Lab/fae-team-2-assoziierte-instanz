package fae.dvp.bezugsperson.models;

import javax.persistence.*;

@Entity
public class DvpAsi {

    @Id
    @GeneratedValue
    private long id;
    
    private Rolle rolle;

    @ManyToOne
    @JoinColumn(name = "DVP_ID")
    private DementiellVeraendertePerson dvp;

    @ManyToOne
    @JoinColumn(name = "ASI_ID")
    private AssoziierteInstanz asi;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }

    public Rolle getRolle() {
        return rolle;
    }
}
