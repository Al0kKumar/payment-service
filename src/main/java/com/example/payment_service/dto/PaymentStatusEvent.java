package com.example.payment_service.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaymentStatusEvent {

    private String orderId;

    private String status;
}
