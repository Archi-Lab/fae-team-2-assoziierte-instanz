package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.consume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.consume.abstracts.EventPayload;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.Nachname;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.Vorname;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DvpPayload extends EventPayload {

    private String id;
    private Vorname vorname;
    private Nachname nachname;

    public Vorname getVorname() {
        return vorname;
    }

    public void setVorname(Vorname vorname) {
        this.vorname = vorname;
    }

    public Nachname getNachname() {
        return nachname;
    }

    public void setNachname(Nachname nachname) {
        this.nachname = nachname;
    }
//
//    public String getAlter() {
//        return alter;
//    }
//
//    public void setAlter(String alter) {
//        this.alter = alter;
//    }
//
//    public String getBild() {
//        return bild;
//    }
//
//    public void setBild(String bild) {
//        this.bild = bild;
//    }
//
//    public String getTracker() {
//        return tracker;
//    }
//
//    public void setTracker(String tracker) {
//        this.tracker = tracker;
//    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
