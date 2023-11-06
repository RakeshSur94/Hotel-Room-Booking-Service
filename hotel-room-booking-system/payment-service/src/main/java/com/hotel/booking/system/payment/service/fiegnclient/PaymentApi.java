package com.hotel.booking.system.payment.service.fiegnclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentApi {

    @GetMapping
    public String paymentTest(){
        return "Payment is successfully done";
    }
}
