package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class Username {

    private String name;

    public  Username(String name){
        this.name = name;
    }

    public Username(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
