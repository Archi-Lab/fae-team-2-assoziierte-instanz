package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class Name {

    private String name;

    public Name(String name){
        this.name = name;
    }

    public Name(){this.name = null;}

    public String getName() {
        return name;
    }
}
