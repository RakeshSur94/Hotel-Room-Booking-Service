package com.hotel.booking.system.payment.service.api;

import com.hotel.booking.system.payment.service.service.IPaymentService;
import com.movie.ticket.booking.system.commons.constants.LoggerConstants;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/payments")
//@RequiredArgsConstructor
//@Slf4j
//public class PaymentApi {
//    private final IPaymentService paymentService;
//
//    @PostMapping
//    public BookingDTO makePayment(@RequestBody BookingDTO bookingDto){
//        log.info(LoggerConstants.ENTERED_CONTROLLER_MESSAGE.getValue(),"create payment",this.getClass(),bookingDto.toString());
//        return this.paymentService.makePayment(bookingDto);
//    }
//}
