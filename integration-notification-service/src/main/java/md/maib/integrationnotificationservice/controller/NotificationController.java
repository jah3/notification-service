package md.maib.integrationnotificationservice.controller;

import md.maib.integrationnotificationservice.model.EventModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public NotificationController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @PostMapping("/send")
    public String sendNotification(@RequestBody EventModel event) {
        rabbitTemplate.convertAndSend("notifications", event);
        return "Notification sent to RabbitMQ successfully!";
    }

}
