package com.ayahathout.RabbitMQWithSpringBoot.configurations;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${queue.name}")
    private String queueName;

    @Value("${exchange.name}")
    private String exchangeName;

    @Value("${routing.key.name}")
    private String routingKeyName;

    // Create a bean from Queue
    @Bean
    public Queue getQueue() {
        return new Queue(queueName);
    }

    // Create a bean from Exchange
    @Bean
    public DirectExchange getExchange() {
        return new DirectExchange(exchangeName);
    }

    // Create a bean from Binding ==> To bind the exchange with queue with the help of the routing key
    @Bean
    public Binding getBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKeyName);
    }

    // Create a bean from message converter
    @Bean
    public MessageConverter getMessageConverter() {
        return new JacksonJsonMessageConverter();
    }

    // Create a bean from Rabbit Template | AMQP Template (RabbitTemplate is an implementation of AMQPTemplate)
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(getMessageConverter());
        return rabbitTemplate;
    }
}
