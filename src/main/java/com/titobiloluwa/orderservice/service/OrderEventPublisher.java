package com.titobiloluwa.orderservice.service;

import com.titobiloluwa.orderservice.data.model.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventPublisher {

    private static final Logger log = LoggerFactory.getLogger(OrderEventPublisher.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${app.kafka.topic.orderCreated}")
    private String orderCreatedTopic;

    public void publishOrderCreated(OrderCreatedEvent event) {
        log.info("Publishing event to topic {}: {}", orderCreatedTopic, event);
        kafkaTemplate.send(orderCreatedTopic, event.getOrderId(), event);
    }
}
