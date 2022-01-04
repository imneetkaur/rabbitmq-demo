package com.stackroute.producer.controller;

import com.stackroute.producer.model.User;
import com.stackroute.producer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class ProducerController {

    private RabbitMQSender rabbitMQSender;

    @Autowired
    public ProducerController(RabbitMQSender rabbitMQSender) {
        this.rabbitMQSender = rabbitMQSender;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping(value = "user")
    public String publishUserDetailsAndSend(@RequestBody User user) {
       rabbitMQSender.sendMessage(user);
       return message;
    }
}
