package md.maib.mailnotificationservice.consumer;

import lombok.extern.log4j.Log4j2;
import md.maib.mailnotificationservice.model.EventModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Component
@Log4j2
public class NotificationConsumer {

    private static final String TELEGRAM_BOT_API_URL = "https://api.telegram.org/bot";

    @Value("${telegram.bot.api.key}")
    private String BOT_TOKEN;

    @Value("${telegram.bot.chatid.personal}")
    private  String CHAT_ID; // Chat ID for the Telegram user
    Logger logger = Logger.getLogger(NotificationConsumer.class.getName());

    @RabbitListener(queues = "notifications")
    public void receiveNotification(@Payload EventModel notification) {
        logger.info("Received notification: " + notification);

        // Prepare the message
        String message = "New Notification:\n" +
                "Name: " + notification.getName() + "\n" +
                "Surname: " + notification.getSurname() + "\n" +
                "Age: " + notification.getAge() + "\n" +
                "Gender: " + notification.getGender();

        // Send the message to Telegram
        sendMessageToTelegram(message);
    }

    private void sendMessageToTelegram(String message) {
        String url = TELEGRAM_BOT_API_URL + BOT_TOKEN + "/sendMessage";

        RestTemplate restTemplate = new RestTemplate();
        try {
            // Send message using RestTemplate
            String response = restTemplate.getForObject(
                    url + "?chat_id=" + CHAT_ID + "&text=" + message,
                    String.class
            );
            logger.info("Message sent successfully to Telegram. Response: " + response);
        } catch (Exception e) {
            logger.severe("Failed to send message to Telegram: " + e.getMessage());
        }
    }
}
