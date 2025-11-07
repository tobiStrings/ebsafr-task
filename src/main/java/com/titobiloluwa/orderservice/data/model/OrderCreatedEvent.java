package com.titobiloluwa.orderservice.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {
    private String orderId;
    private String customerEmail;
    private String productId;
    private Integer quantity;
    private Instant createdAt;
    private String source; // e.g., 'order-service'
    private String version; // e.g., 'v1'
}
