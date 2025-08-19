package com.example.payment_service.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentStatusEvent {

    private Long userId;

    private String orderId;

    private String userEmail;

    private String status;
}
