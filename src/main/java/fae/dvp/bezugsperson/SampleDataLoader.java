package fae.dvp.bezugsperson;

import fae.dvp.bezugsperson.infrastructure.eventing.AsiCreatedEvent;
import fae.dvp.bezugsperson.infrastructure.eventing.AsiEvent;
import fae.dvp.bezugsperson.infrastructure.eventing.KafkaGateway;
import fae.dvp.bezugsperson.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import fae.dvp.bezugsperson.repositories.AssoziierteInstanzRepository;

import java.util.concurrent.TimeUnit;


@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AssoziierteInstanzRepository assoziierteInstanzRepository;

    @Autowired
    private BezugspersonApplication bezugspersonApplication;

    private final KafkaGateway eventPublisher;
    private static final Logger log = LoggerFactory.getLogger(SampleDataLoader.class);
    @Autowired
    SampleDataLoader(final KafkaGateway eventPublisher){
        this.eventPublisher = eventPublisher;
    }

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

        AsiEvent asiEvent = new AsiCreatedEvent(asi);
        try {
            SendResult<String, String> sendResult = eventPublisher.publishTrackingEvent(asiEvent)
                    .get(1, TimeUnit.SECONDS);
            log.info(sendResult.toString());
        } catch (final Exception e){
            log.info("An " + e.getClass() + " occured!");
        }
    }
}

