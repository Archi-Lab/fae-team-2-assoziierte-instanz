package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.consume.abstracts.processed;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProcessedEventRepository extends JpaRepository<ProcessedEventEntity, String> {

    ProcessedEventEntity findByTopicAndKey(String topic, String key);

}
