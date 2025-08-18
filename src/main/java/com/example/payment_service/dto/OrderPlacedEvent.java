package com.example.payment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private String userid;

    private String orderid;

    private double amount;

    private String status;
}
