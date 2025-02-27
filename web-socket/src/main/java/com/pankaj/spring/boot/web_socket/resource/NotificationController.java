package com.pankaj.spring.boot.web_socket.resource;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

    //app/sendMessage
    @SendTo("/topic/notifications")
    @MessageMapping("/sendMessage")
    public String sendMessage(String message) {
        System.out.println("Message :" + message);
        return message;
    }
}
