package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.consume.abstracts.configuration;


public interface ConsumerTopicConfig {

    String getName();

    boolean isPayloadSensitive();

}
