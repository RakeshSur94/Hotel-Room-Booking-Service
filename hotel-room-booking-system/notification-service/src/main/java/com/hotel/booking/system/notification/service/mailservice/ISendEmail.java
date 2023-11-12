package com.hotel.booking.system.notification.service.mailservice;

import com.movie.ticket.booking.system.commons.dto.BookingDTO;

public interface ISendEmail {
    public void sendEmail(BookingDTO bookingDTO);
}
