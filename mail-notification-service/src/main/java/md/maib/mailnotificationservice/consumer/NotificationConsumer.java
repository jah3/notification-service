package md.maib.mailnotificationservice.consumer;

import lombok.extern.log4j.Log4j2;
import md.maib.mailnotificationservice.model.EventModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Log4j2
public class NotificationConsumer {

    Logger logger = Logger.getLogger(NotificationConsumer.class.getName());

    @RabbitListener(queues = "notifications")
    public void receiveNotification(@Payload EventModel notification) {
    logger.info("Received notification: " + notification);  }

}
