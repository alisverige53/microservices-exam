package com.example.orderservice.dto;

import com.example.orderservice.model.Order;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponseDTO {
    private Order order;
    private ProductDTO product;
}
