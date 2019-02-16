package de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi;

import javax.persistence.Embeddable;

@Embeddable
public class Passwort {

    private String passwort;

    public Passwort(String passwort){
        this.passwort = passwort;
    }

    public Passwort(){}

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
