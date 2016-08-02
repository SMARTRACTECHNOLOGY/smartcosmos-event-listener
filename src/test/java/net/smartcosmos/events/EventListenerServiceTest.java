package net.smartcosmos.events;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EventListenerService.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "spring.cloud.config.enabled=false" })
@ActiveProfiles("test")
public class EventListenerServiceTest {


    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1);

    @Value("${local.server.port}")
    private int port;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("kafka.broker.address", embeddedKafka.getBrokersAsString());
    }


    @Test
    public void thatContextLoads() throws Exception {

    }

}
