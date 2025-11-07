package com.titobiloluwa.orderservice.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {
    @NotBlank
    private String orderId;

    @NotBlank
    private String customerEmail;

    @NotBlank
    private String productId;

    @NotNull
    @Min(1)
    private Integer quantity;
}
