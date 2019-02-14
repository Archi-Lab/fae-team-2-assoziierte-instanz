package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class Passwort {

    private String passwort;

    public Passwort(String passwort){
        this.passwort = passwort;
    }

    public Passwort(){this.passwort = null;}

    public String getPasswort() {
        return passwort;
    }
}
