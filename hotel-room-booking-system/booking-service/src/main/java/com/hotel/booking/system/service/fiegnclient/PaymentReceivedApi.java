package com.hotel.booking.system.service.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "payment-service")
public interface PaymentReceivedApi {
    @GetMapping("/payments")
    public String paymentTest();
}
