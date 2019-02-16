package de.th.koeln.fae.microservice_assoziierte_instanz.models;

import javax.persistence.Embeddable;

@Embeddable
public class Vorname {

    private String vorname;

    public Vorname(){

    }

    public Vorname(String vorname){
        //darf keine Numerischen Zeichen enthalten
        String expression = "(?U)[\\p{L}\\p{M}\\s'-]+";
        if(!vorname.matches(expression)){
            throw new IllegalArgumentException("Ein Vorname darf nur aus Groß- bzw. Kleinbuchstaben bestehen.");
        }
        this.vorname = vorname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "Vorname{" +
                "vorname='" + vorname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other){
        return other.getClass() == this.getClass() && ((Vorname) other).vorname.equals(this.vorname);
    }
}