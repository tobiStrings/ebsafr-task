package com.titobiloluwa.orderservice.data.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String orderId;

    private String customerEmail;
    private String productId;
    private Integer quantity;
    private Instant createdAt = Instant.now();
}
