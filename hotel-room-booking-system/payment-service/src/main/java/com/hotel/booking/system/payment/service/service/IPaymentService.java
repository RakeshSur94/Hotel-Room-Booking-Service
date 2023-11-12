package com.hotel.booking.system.payment.service.service;

import com.movie.ticket.booking.system.commons.dto.BookingDTO;

public interface IPaymentService {
    public BookingDTO makePayment(BookingDTO bookingDTO);
}
