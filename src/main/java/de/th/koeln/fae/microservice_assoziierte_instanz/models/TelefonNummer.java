package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class TelefonNummer {

    private String nummer;

    public TelefonNummer(String nummer){
        this.nummer = nummer;
    }

    public TelefonNummer(){}

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }
}



