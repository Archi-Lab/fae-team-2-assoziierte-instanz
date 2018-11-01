package fae.dvp.bezugsperson;

import javax.persistence.*;

@Entity
public class DementiellVeraendertePerson {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(mappedBy = "dvp")
    private Bezugsperson bezugsperson;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
