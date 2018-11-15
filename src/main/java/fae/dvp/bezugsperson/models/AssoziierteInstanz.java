package fae.dvp.bezugsperson.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class AssoziierteInstanz {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Embedded
    private Username username;

    @Enumerated
    private Rolle rolle;

    @Embedded
    private Passwort passwort;

    @Embedded
    private Email email;

    //@Embedded
    //private Name vorname;

    @Embedded
    private TelefonNummer telefonnummer;

    @OneToMany(mappedBy = "asi",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DvpAsi> dvpAsis;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "asi_dvp",
            joinColumns = @JoinColumn(name = "asi_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dvp_id",
            referencedColumnName = "id"))
    private List<DementiellVeraendertePerson> dvps;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }

    public void setPasswort(Passwort passwort) {
        this.passwort = passwort;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    //public void setVorname(Name vorname) {this.vorname = vorname;}

    public void setTelefonnummer(TelefonNummer telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Email getEmail() {
        return email;
    }

    //public Name getVorname() {return vorname;}

    public Passwort getPasswort() {
        return passwort;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public TelefonNummer getTelefonnummer() {
        return telefonnummer;
    }

    public Username getUsername() {
        return username;
    }

    @Override
    public String toString(){
       return   "AssoziierteInstanz{" + id + '\'' +
                "Username: " + username + '\'' +
                "Passwort: " + passwort + '\'' +
                "Rolle: " + rolle + '}';

    }
}

