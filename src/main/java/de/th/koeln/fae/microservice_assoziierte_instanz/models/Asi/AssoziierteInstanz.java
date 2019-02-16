package de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.produce.EventPublishingEntityListener;
import de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.produce.EventSource;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.dvp.DementiellVeraendertePerson;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.EntityUUID4;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.Nachname;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.Vorname;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(EventPublishingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssoziierteInstanz extends EntityUUID4 implements EventSource {

    //region Attribute
    @Embedded
    private Vorname vorname;

    @Embedded
    private Nachname nachname;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "asi_dvp",
            joinColumns = @JoinColumn(name = "asi_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dvp_id",
                    referencedColumnName = "id"))
    private List<DementiellVeraendertePerson> dvps;

    @Enumerated
    private Rolle rolle;

    @Embedded
    private Username username;

    @Embedded
    private Passwort passwort;

    @Embedded
    private Email email;

    @Embedded
    private TelefonNummer telefonnummer;

    @Version
    private Long version = 0L;

    //region Getter, Setter

    public Vorname getVorname() { return vorname; }

    public void setVorname(Vorname vorname) { this.vorname = vorname; }

    public Nachname getNachname() { return nachname; }

    public void setNachname(Nachname nachname) { this.nachname = nachname; }

    public List<DementiellVeraendertePerson> getDvps() { return dvps; }

    public void setDvps(List<DementiellVeraendertePerson> dvps) { this.dvps = dvps; }

    public Rolle getRolle() { return rolle; }

    public void setRolle(Rolle rolle) { this.rolle = rolle; }

    public Username getUsername() { return username; }

    public void setUsername(Username username) { this.username = username; }

    public Passwort getPasswort() { return passwort; }

    public void setPasswort(Passwort passwort) { this.passwort = passwort; }

    public Email getEmail() { return email; }

    public void setEmail(Email email) { this.email = email; }

    public TelefonNummer getTelefonnummer() { return telefonnummer; }

    public void setTelefonnummer(TelefonNummer telefonnummer) { this.telefonnummer = telefonnummer; }

    //endregion

    //region Override-Methoden
    @Override
    public Long getVersion() { return version; }

    @Override
    public String getAggregateName() {
        return "asi";
    }

    @Override
    public String toString(){
       return   "AssoziierteInstanz{" + getId() + '\'' +
                "Username: " + username + '\'' +
                "Passwort: " + passwort + '\'' +
                "Rolle: " + rolle + '}';

    }
    //endregion
}

