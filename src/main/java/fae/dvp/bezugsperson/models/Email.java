package fae.dvp.bezugsperson.models;

import javax.persistence.Embeddable;

@Embeddable
public class Email {

    private String Email;

    public Email(String Email){
        this.Email = Email;
    }

    public  Email(){
        this.Email = null;
    }

    public String getEmail() {
        return Email;
    }
}
