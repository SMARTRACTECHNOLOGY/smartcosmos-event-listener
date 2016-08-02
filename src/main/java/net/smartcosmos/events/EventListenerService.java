package net.smartcosmos.events;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * @author voor
 */
@net.smartcosmos.annotation.EnableSmartCosmosEvents
@SpringBootApplication
@Slf4j
public class EventListenerService {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EventListenerService.class).web(true).run(args);
    }

    @KafkaListener(topics = {"stupid-event"})
    public void onEvent(@Payload SmartCosmosEvent event,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        Acknowledgment acknowledgment) {

        log.info("Received {} event: {}", event.getEventType(), event);

        log.info("Event data is type: {}",event.getData().getClass());

    }
}
