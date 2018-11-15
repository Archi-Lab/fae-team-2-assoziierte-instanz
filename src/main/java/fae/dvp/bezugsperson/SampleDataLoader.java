package fae.dvp.bezugsperson;

import fae.dvp.bezugsperson.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import fae.dvp.bezugsperson.repositories.AssoziierteInstanzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AssoziierteInstanzRepository assoziierteInstanzRepository;

    @Autowired
    private BezugspersonApplication bezugspersonApplication;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final AssoziierteInstanz asi = new AssoziierteInstanz();

        asi.setEmail(new Email("a@b.c"));
        asi.setPasswort(new Passwort("hunter1"));
        asi.setRolle(Rolle.BEZUGSPERSON);
        asi.setUsername(new Username("Hans Wurst"));
        asi.setTelefonnummer(new TelefonNummer("1234567890"));
        asi.setId(0);

        final AssoziierteInstanz savedAsi = this.assoziierteInstanzRepository.save(asi);
    }
}

