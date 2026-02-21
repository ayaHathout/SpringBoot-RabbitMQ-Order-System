package com.ayahathout.RabbitMQWithSpringBoot.publishers;

import com.ayahathout.RabbitMQWithSpringBoot.dtos.OrderRequestDTO;
import com.ayahathout.RabbitMQWithSpringBoot.dtos.OrderResponseDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class Publisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${exchange.name}")
    private String exchangeName;

    @Value("${routing.key.name}")
    private String routingKeyName;

    @PostMapping
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setOrder(orderRequestDTO);

        // Publish the message to the RabbitMQ ==> This message should contain all the information the consumers (here: Payment service & Notification service) will need to do their business logic
        // Payment service & Notification service take a lot of time to do their work ==> So I immediately send orderResponseDTO to user and the consumers do their work in the background
        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, orderResponseDTO);

        // This will return to user immediately ==> User does not blocked
        return orderResponseDTO;
    }
}
