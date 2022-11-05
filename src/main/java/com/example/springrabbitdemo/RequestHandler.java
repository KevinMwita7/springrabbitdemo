package com.example.springrabbitdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHandler {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/{name}")
    public String handleRequest(@PathVariable String name) {
        rabbitTemplate.convertAndSend(QueueConfig.MESSAGE_QUEUE, name);
        return "Hello " + name;
    }
}