package com.hotel.booking.system.service.broker;

import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service")
public interface PaymentReceivedApi {


    @PostMapping("/payments")
    public BookingDTO makePayment(@RequestBody BookingDTO bookingDTO);
}
