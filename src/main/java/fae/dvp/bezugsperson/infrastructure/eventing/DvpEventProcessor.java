package fae.dvp.bezugsperson.infrastructure.eventing;

import fae.dvp.bezugsperson.infrastructure.eventing.abstracts.AbstractDomainEventProcessor;
import fae.dvp.bezugsperson.infrastructure.eventing.abstracts.EventParser;
import fae.dvp.bezugsperson.infrastructure.eventing.abstracts.EventProcessingState;
import fae.dvp.bezugsperson.infrastructure.eventing.abstracts.configuration.ConsumerTopicConfig;
import fae.dvp.bezugsperson.infrastructure.eventing.abstracts.processed.ProcessedEventService;
import fae.dvp.bezugsperson.models.DementiellVeraendertePerson;
import fae.dvp.bezugsperson.repositories.DementiellVeraendertePersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class DvpEventProcessor extends AbstractDomainEventProcessor<DvpPayload, DvpEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDomainEventProcessor.class);

    private final DementiellVeraendertePersonRepository repository;

    @Inject
    public DvpEventProcessor(final ConsumerTopicConfig dvpTopicConfig, final EventParser eventParser, final ProcessedEventService processedEventService, final DementiellVeraendertePersonRepository repository) {
        super(DvpEvent.class, dvpTopicConfig, eventParser, processedEventService);
        this.repository = repository;
    }

    @Override
    protected EventProcessingState processEvent(final DvpEvent dvpEvent) {
        switch (dvpEvent.getType()) {
            case "dvp-created":
            case "dvp-updated":
                repository.save(toDvp(dvpEvent));
                break;
            default:
                LOG.warn("Unexpected type: '{}' of message with key '{}'", dvpEvent.getType(),
                        dvpEvent.getKey());
                return EventProcessingState.UNEXPECTED_ERROR;
        }
        return EventProcessingState.SUCCESS;
    }

    private DementiellVeraendertePerson toDvp(final DvpEvent dvpEvent) {
        final DementiellVeraendertePerson dvp = new DementiellVeraendertePerson();
        dvp.setId(dvpEvent.getPayload().getId());

        return dvp;
    }

}
