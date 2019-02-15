package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String email;

    public Email(String Email){
        this.email = Email;
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
