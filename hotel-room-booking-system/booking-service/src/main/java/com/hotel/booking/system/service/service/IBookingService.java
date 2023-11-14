package com.hotel.booking.system.service.service;

import com.movie.ticket.booking.system.commons.dto.BookingDTO;

public interface IBookingService {
    public BookingDTO createBooking(BookingDTO bookingDTO);
    public void processBooking(BookingDTO bookingDTO);
}
