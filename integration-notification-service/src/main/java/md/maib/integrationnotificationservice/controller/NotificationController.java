package md.maib.integrationnotificationservice.controller;

import md.maib.integrationnotificationservice.model.EventModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public NotificationController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @PostMapping(value = "/send", consumes = "application/x-www-form-urlencoded")
    public String sendNotificationFromForm(@ModelAttribute EventModel event) {
        rabbitTemplate.convertAndSend("notifications", event);
        return "Notification sent to RabbitMQ successfully!";
    }

}
