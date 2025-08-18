package com.example.payment_service.kafka;

import com.example.payment_service.dto.OrderPlacedEvent;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderPlacedListener {

    private PaymentRepository paymentRepository;

    @KafkaListener(topics = "order-placed-topic", groupId = "payment-service-group")
    public void listen(OrderPlacedEvent event){
        System.out.println("Received message for order: " + event.getOrderid());

        // Simulate payment processing
        boolean paymentSuccessful = Math.random() > 0.1;

        String paymentStatus = paymentSuccessful ? "PAID" : "FAILED";

        // Save the payment status to the database
        Payment payment = new Payment();
        payment.setOrderid(event.getOrderid());
        payment.setUserid(event.getUserid());
        payment.setAmount(event.getAmount());
        payment.setStatus(paymentStatus);

        paymentRepository.save(payment);

        System.out.println("Payment for order " + event.getOrderid() + " processed with status: " + paymentStatus);
    }

}
