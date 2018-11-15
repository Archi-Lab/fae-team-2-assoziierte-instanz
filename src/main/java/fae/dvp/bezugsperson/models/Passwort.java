package fae.dvp.bezugsperson.models;

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
