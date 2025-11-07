package com.titobiloluwa.orderservice.controller;

import com.titobiloluwa.orderservice.data.model.OrderCreatedEvent;
import com.titobiloluwa.orderservice.data.dto.OrderRequest;
import com.titobiloluwa.orderservice.service.OrderEventPublisher;
import com.titobiloluwa.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest request) {
        return ResponseEntity.accepted().body(orderService.createOrder(request));
    }
}
