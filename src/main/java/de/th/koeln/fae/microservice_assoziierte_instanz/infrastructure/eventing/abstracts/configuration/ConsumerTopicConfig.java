package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.abstracts.configuration;


public interface ConsumerTopicConfig {

    String getName();

    boolean isPayloadSensitive();

}
