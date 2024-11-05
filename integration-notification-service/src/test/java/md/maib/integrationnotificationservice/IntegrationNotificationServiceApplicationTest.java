package md.maib.integrationnotificationservice;


import md.maib.integrationnotificationservice.model.EventModel;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationNotificationServiceTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSendNotificationToRabbitMQ() {
        // Create a sample user event
        EventModel event = new EventModel();
        event.setName("John");
        event.setSurname("Doe");
        event.setAge(30);
        event.setGender("Male");

        // Create HTTP request to send data
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<EventModel> request = new HttpEntity<>(event, headers);

        // Send POST request to the controller
        ResponseEntity<String> response = restTemplate.exchange(
                "/api/notifications/send",
                HttpMethod.POST,
                request,
                String.class
        );

        assertEquals("Notification sent to RabbitMQ successfully!", response.getBody());
    }
}