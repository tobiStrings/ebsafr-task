package com.titobiloluwa.orderservice.data.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateOrderResponse {
    private String message;
    private boolean success;
    private String status;
    private String orderID;
}
