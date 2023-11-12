package com.hotel.booking.system.payment.service.dto;

import com.movie.ticket.booking.system.commons.dto.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private UUID bookingId;
    private PaymentStatus paymentStatus;
    private Double paymentAmount;
}
