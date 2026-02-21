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

    @RabbitListener(queues = {"${queue.name}"})
    public void consume(OrderResponseDTO orderResponseDTO) {
        System.out.println("Consumer received " + orderResponseDTO);
    }
}
