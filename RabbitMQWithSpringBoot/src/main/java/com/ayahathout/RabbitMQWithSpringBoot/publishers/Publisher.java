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

        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, orderResponseDTO);

        return orderResponseDTO;
    }
}
