package fae.dvp.bezugsperson.infrastructure.eventing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fae.dvp.bezugsperson.models.AsiEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class KafkaGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaGateway.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final String topic;

    @Autowired
    public KafkaGateway(final KafkaTemplate<String, String> kafkaTemplate, final ObjectMapper objectMapper,
                        @Value("bezugsperson") final String topic){
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
        this.topic = topic;
    }

    public ListenableFuture<SendResult<String, String>> publishTrackingEvent(AsiEvent asiEvent) {
        LOGGER.info("publishing event {} to topic {}", asiEvent.getId(), topic);
        return kafkaTemplate.send(topic, asiEvent.getKey(), toAsiEventMessage(asiEvent));
    }

    private String toAsiEventMessage(AsiEvent asiEvent){
        try{
            final Map<String, Object> message = new HashMap<>();
            message.put("id", asiEvent.getId());
            message.put("key", asiEvent.getKey());
            message.put("time", asiEvent.getTime());
            message.put("type", asiEvent.getType());
            message.put("version", asiEvent.getVersion());
            message.put("payload", objectMapper.readValue(asiEvent.getPayload(objectMapper), asiEvent.getEntityType()));
            return objectMapper.writeValueAsString(message);
        } catch (final JsonProcessingException e) {
            LOGGER.error("Could not serialize event with id {}", asiEvent.getId(), e);
            return "";
        } catch (IOException e){
            LOGGER.error("Could not read payload for event with id {}", asiEvent.getId(), e);
            return "";
        }
    }
}
