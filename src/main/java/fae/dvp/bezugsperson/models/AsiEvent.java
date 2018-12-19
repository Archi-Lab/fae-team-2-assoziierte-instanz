package fae.dvp.bezugsperson.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.ZonedDateTime;

public interface AsiEvent {

    long getId();

    String getKey();

    Long getVersion();

    ZonedDateTime getTime();

    byte[] getPayload(ObjectMapper objectMapper) throws JsonProcessingException;

    Class<?> getEntityType();

    String getType();

}
