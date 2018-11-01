package fae.dvp.bezugsperson.models;

import javax.persistence.*;

@Entity
public class Bezugsperson {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String rolle;
    private String passwort;

    @OneToOne
    @JoinColumn(name = "dvp_id", referencedColumnName = "id")
    private DementiellVeraendertePerson dvp;

    public void setId(long id) {
        this.id = id;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public String getPasswort() {
        return passwort;
    }

    public String getRolle() {
        return rolle;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString(){
       return   "Bezugsperson{" + id + '\'' +
                "Username: " + username + '\'' +
                "Passwort: " + passwort + '\'' +
                "Rolle: " + rolle + '}';
    }
}

