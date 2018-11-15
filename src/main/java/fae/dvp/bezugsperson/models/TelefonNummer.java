package fae.dvp.bezugsperson.models;

import javax.persistence.Embeddable;

@Embeddable
public class TelefonNummer {

    private String nummer;

    public TelefonNummer(String nummer){
        this.nummer = nummer;
    }

    public TelefonNummer(){this.nummer=null;}

    public String getNummer() {
        return nummer;
    }
}



