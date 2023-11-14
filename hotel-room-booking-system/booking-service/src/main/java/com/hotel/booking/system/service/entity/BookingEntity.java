package com.hotel.booking.system.service.entity;

import com.movie.ticket.booking.system.commons.dto.BookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookingId;
    @Column(length = 25,name = "user_id")
    private String userId;
    @ElementCollection
    private List<String> customerNames;
    @Column(length = 25,name = "email_id")
    private String emailId;
    @Column(length = 10,name = "mobile_number")
    private Long mobNumber;
    @Column(name = "checkIn_time")
    private LocalDate checkIn;
    @Column(name = "checkOut_time")
    private LocalDate checkOut;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @Column(name = "booking_amount")
    private Double bookingAmount;


}
