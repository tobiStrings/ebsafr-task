package com.titobiloluwa.orderservice.service;

import com.titobiloluwa.orderservice.data.dto.CreateOrderResponse;
import com.titobiloluwa.orderservice.data.dto.OrderRequest;

public interface OrderService {
    CreateOrderResponse createOrder(OrderRequest orderRequest);
}
