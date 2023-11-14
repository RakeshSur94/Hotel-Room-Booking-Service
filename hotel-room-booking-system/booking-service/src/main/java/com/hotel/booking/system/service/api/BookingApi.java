package com.hotel.booking.system.service.api;

import com.hotel.booking.system.service.service.IBookingService;
import com.movie.ticket.booking.system.commons.constants.LoggerConstants;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
@Slf4j
public class BookingApi {
    private final IBookingService bookingService;

    @PostMapping
    public BookingDTO registerBooking(@RequestBody BookingDTO bookingDTO){
        log.info(LoggerConstants.ENTERED_CONTROLLER_MESSAGE.getValue(),"registerBooking",this.getClass(),bookingDTO.toString());
        return this.bookingService.createBooking(bookingDTO);
    }

}
