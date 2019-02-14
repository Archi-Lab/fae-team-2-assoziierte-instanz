package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class Username {

    private String name;

    public  Username(String name){
        this.name = name;
    }

    public Username(){this.name = null;}

    public String getName() {
        return name;
    }
}
