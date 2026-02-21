package com.ayahathout.RabbitMQWithSpringBoot.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDTO implements Serializable {
    private String productName;
    private String productPrice;
    private String productQuantity;
}
