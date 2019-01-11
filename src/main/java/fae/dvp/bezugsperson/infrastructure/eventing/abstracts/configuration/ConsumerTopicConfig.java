package fae.dvp.bezugsperson.infrastructure.eventing.abstracts.configuration;


public interface ConsumerTopicConfig {

    String getName();

    boolean isPayloadSensitive();

}
