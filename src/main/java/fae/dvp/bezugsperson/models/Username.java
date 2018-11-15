package fae.dvp.bezugsperson.models;

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
