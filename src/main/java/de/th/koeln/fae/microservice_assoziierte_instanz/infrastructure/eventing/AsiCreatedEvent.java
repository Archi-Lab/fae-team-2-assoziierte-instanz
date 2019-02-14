package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.AssoziierteInstanz;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AsiCreatedEvent implements AsiEvent {

    public AsiCreatedEvent(AssoziierteInstanz asi)
    {
        this.id = (long)Math.random();
        this.asi = asi;
        this.instant = Instant.now();
    }

    final long id;
    final AssoziierteInstanz asi;
    final Instant instant;

    public long getId() {
        return id;
    }

    public String getKey() {
        return Long.toString(asi.getId());
    }

    @Override
    public ZonedDateTime getTime() {
        return instant.atZone(ZoneId.systemDefault());
    }

    //The tracker Entity doesn't implement any versioning patterns (yet), therefore event versions are always 0
    public Long getVersion() {
        return 0L;
    }

    public byte[] getPayload(ObjectMapper objectMapper) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(asi);
    }

    public Class<?> getEntityType() {
        return asi.getClass();
    }

    public String getType()
    {
        return "asi-created";
    }

}