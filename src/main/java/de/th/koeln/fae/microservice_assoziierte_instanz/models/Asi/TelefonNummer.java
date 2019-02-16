package de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi;

import javax.persistence.Embeddable;

@Embeddable
public class TelefonNummer {

    private String nummer;

    public TelefonNummer(String nummer){

        String expression = "^[0-9]*$";
        if(!nummer.matches(expression)){
            throw new IllegalArgumentException("Eine Telefonnummer darf nur aus Zahlen bestehen.");
        }
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



