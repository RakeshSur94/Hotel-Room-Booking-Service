package com.hotel.booking.system.service.kafka.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceKafkaPublisher {

    public final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void publishTopicToSubscriber(BookingDTO bookingDTO){
        log.info("Publishing Booking Details to the payment-request kafka topic");
        try {
            this.kafkaTemplate.send("payment-request",objectMapper.writeValueAsString(bookingDTO));
        } catch (JsonProcessingException e) {
            log.error("Error while publishing booking details to the payment-request kafka topic");
        }

    }
}
