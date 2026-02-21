package com.ayahathout.RabbitMQWithSpringBoot.dtos;

import com.ayahathout.RabbitMQWithSpringBoot.models.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDTO implements Serializable {
    private Order order;
    private String orderStatus = "Placed";
    private String message = "Your order has been placed successfully";
}
