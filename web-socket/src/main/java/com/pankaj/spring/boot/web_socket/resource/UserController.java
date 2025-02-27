package com.pankaj.spring.boot.web_socket.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
public class UserController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/user/createUser")
    public User createUser() {

        User user = new User("A", RandomGenerator.getDefault().nextInt());
//        simpMessagingTemplate.convertAndSendToUser("Pankaj","/user/notifications",user);
        simpMessagingTemplate.convertAndSend("/topic/user", user);
        return user;
    }
}
