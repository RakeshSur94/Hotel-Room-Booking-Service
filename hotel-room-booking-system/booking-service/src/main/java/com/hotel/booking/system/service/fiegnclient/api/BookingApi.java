package com.hotel.booking.system.service.fiegnclient.api;

import com.hotel.booking.system.service.fiegnclient.PaymentReceivedApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingApi {
    @Autowired
    private PaymentReceivedApi paymentReceivedApi;

    @GetMapping
    public String test(){
        return this.paymentReceivedApi.paymentTest();
    }

}
