package com.example.payment.payment_service.controller;

import com.example.payment.payment_service.model.Payment;
import com.example.payment.payment_service.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public Payment makePayment(@RequestBody Payment paymentRequest) {
        // Gán trạng thái thành công tạm thời
        paymentRequest.setStatus("SUCCESS");
        return paymentRepository.save(paymentRequest);
    }
}
