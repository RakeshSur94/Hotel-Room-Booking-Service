package com.movie.ticket.booking.system.commons.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class BookingDTO {

    private UUID bookingId;

    @NotBlank(message = "user id is mandatory and it cannot be blank")
    private String userId;
    @NotNull(message = "user must entered at least two customer ")
    private List<String> customerNames;
    @Email(message = "Enter valid emil id")
    private String emailId;
    @NotBlank(message = "mobile number is mandatory and it cannot be blank")
    private String mobNumber;
    @NotNull(message = "checkIn time is mandatory")
    private LocalDate checkIn;
    @NotNull(message = "checkOut time is mandatory")
    private LocalDate checkOut;
    private BookingStatus bookingStatus;
    @NotNull(message = "booking amount is mandatory")
    @Positive(message = "amount must be greater than zero")
    private Double bookingAmount;
}
