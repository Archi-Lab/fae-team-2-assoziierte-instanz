package de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String email;

    public Email(String email){

        String expression = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
        if(!email.matches(expression)){
            throw new IllegalArgumentException("Eine Email hat die Form \"something@somewhere.go\".");
        }
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
