package fae.dvp.bezugsperson.infrastructure.eventing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import fae.dvp.bezugsperson.infrastructure.eventing.abstracts.EventPayload;
import fae.dvp.bezugsperson.models.Vorname;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DvpPayload extends EventPayload {

    private long id;
//    private Vorname vorname;
//    private String nachname;
//    private String alter;
//    private String bild;
//    private String tracker;

//    public Vorname getVorname() {
//        return vorname;
//    }
//
//    public void setVorname(Vorname vorname) {
//        this.vorname = vorname;
//    }

//    public String getNachname() {
//        return nachname;
//    }
//
//    public void setNachname(String nachname) {
//        this.nachname = nachname;
//    }
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
