package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.produce.EventPublishingEntityListener;
import de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.produce.EventSource;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(EventPublishingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssoziierteInstanz extends EntityUUID4 implements EventSource {

    @Version
    private Long version = 0L;

    @Embedded
    private Username username;

    @Enumerated
    private Rolle rolle;

    @Embedded
    private Passwort passwort;

    @Embedded
    private Email email;

    @Embedded
    private Vorname vorname;

    @Embedded
    private Nachname nachname;

    @Embedded
    private TelefonNummer telefonnummer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "asi_dvp",
            joinColumns = @JoinColumn(name = "asi_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dvp_id",
            referencedColumnName = "id"))
    private List<DementiellVeraendertePerson> dvps;

    @Override
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String getAggregateName() {
        return "asi";
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

    public void setVorname(Vorname vorname) {this.vorname = vorname;}

    public void setTelefonnummer(TelefonNummer telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Email getEmail() {
        return email;
    }

    public Vorname getVorname() {return vorname;}

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

    public Nachname getNachname() {
        return nachname;
    }

    public void setNachname(Nachname nachname) {
        this.nachname = nachname;
    }

    public List<DementiellVeraendertePerson> getDvps() {
        return dvps;
    }

    public void setDvps(List<DementiellVeraendertePerson> dvps) {
        this.dvps = dvps;
    }

    @Override
    public String toString(){
       return   "AssoziierteInstanz{" + getId() + '\'' +
                "Username: " + username + '\'' +
                "Passwort: " + passwort + '\'' +
                "Rolle: " + rolle + '}';

    }
}

