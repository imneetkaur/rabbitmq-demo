package com.stackroute.consumer.service;

import com.stackroute.consumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQService implements RabbitListenerConfigurer {

    private static final Logger logger= LoggerFactory.getLogger(RabbitMQService.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(User user){
        logger.info("Hello");
        logger.info("Received user details..." + user);
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {

    }
}
