package com.ayahathout.RabbitMQWithSpringBoot.consumers;

import com.ayahathout.RabbitMQWithSpringBoot.dtos.OrderResponseDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Consume any message exists in the RabbitMQ named "${queue.name}"
    // These consumers are supposed to be Payment service & Notification service
    // The consumer just takes the message which includes all the information it'll need and does its business logic
    @RabbitListener(queues = {"${queue.name}"})
    public void consume(OrderResponseDTO orderResponseDTO) {
        System.out.println("Consumer received " + orderResponseDTO);
    }
}
