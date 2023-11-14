package com.hotel.booking.system.service.kafka.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.booking.system.service.service.IBookingService;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceKafkaListener {

    private final ObjectMapper objectMapper;
    private final IBookingService bookingService;

    @KafkaListener(topics = "payment-response",id = "paymentresponse")
    public void consumerFromPaymentResponseTopic(String bookingDtoJson){
        log.info("Receiving confirmation on booking details from payment-response kafka topic");
        try {
            BookingDTO bookingDTO=objectMapper.readValue(bookingDtoJson,BookingDTO.class);
            this.bookingService.processBooking(bookingDTO);
        } catch (JsonProcessingException e) {
            log.error("Error while receiving confirmation on booking details from " +
                    "payment-response kafka topic");
        }
    }
}
