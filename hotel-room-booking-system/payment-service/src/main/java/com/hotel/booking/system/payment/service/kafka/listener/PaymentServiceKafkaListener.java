package com.hotel.booking.system.payment.service.kafka.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.booking.system.payment.service.service.IPaymentService;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceKafkaListener {
    private final ObjectMapper objectMapper;
    private final IPaymentService paymentService;

    @KafkaListener(topics = "payment-request",id = "paymentrequest")
    public void consumeFromPaymentRequestTopic(String bookingDtoJson){
        log.info("received booking details from the payment-request kafka topic in payment-service");

        try {
            BookingDTO bookingDTO=objectMapper.readValue(bookingDtoJson,BookingDTO.class);
            this.paymentService.processPayment(bookingDTO);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}
