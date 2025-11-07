package com.titobiloluwa.orderservice.service;

import com.titobiloluwa.orderservice.data.dto.CreateOrderResponse;
import com.titobiloluwa.orderservice.data.dto.OrderRequest;
import com.titobiloluwa.orderservice.data.model.Order;
import com.titobiloluwa.orderservice.data.model.OrderCreatedEvent;
import com.titobiloluwa.orderservice.data.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final OrderEventPublisher publisher;

    @Override
    public CreateOrderResponse createOrder(OrderRequest orderRequest) {
        Order order = createOrderObjectFromRequest(orderRequest);
        OrderCreatedEvent event = OrderCreatedEvent.builder()
                .orderId(order.getOrderId())
                .customerEmail(order.getCustomerEmail())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .createdAt(Instant.now())
                .source("order-service")
                .version("v1")
                .build();

        publisher.publishOrderCreated(event);

        return CreateOrderResponse.builder()
                .status("created")
                .message("Order created successfully")
                .success(true)
                .orderID(order.getOrderId())
                .build();
    }

    private Order createOrderObjectFromRequest(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderId(orderRequest.getOrderId());
        order.setCustomerEmail(orderRequest.getCustomerEmail());
        order.setProductId(orderRequest.getProductId());
        order.setQuantity(orderRequest.getQuantity());
        return orderRepository.save(order);
    }
}
