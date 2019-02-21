package de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String email;

    public Email(String email){
        this.email = email;
    }

    public  Email(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}