package net.smartcosmos.events;

import lombok.extern.slf4j.Slf4j;
import net.smartcosmos.spring.EnableSmartCosmos;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author voor
 */
@EnableSmartCosmos
@SpringBootApplication
@SmartCosmosEventListener
@Slf4j
public class EventListenerService {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EventListenerService.class).web(true).run(args);
	}

	@SmartCosmosEventListenerReceiver
	public void onEvent(SmartCosmosEvent event) {

		log.info("Received {} event: {}", event.getEventType(), event);
	}
}
