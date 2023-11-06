package com.movie.ticket.booking.system.commons.dto;

public enum BookingStatus {
    PENDING,        // The initial status when a booking request is submitted
    CANCELLED,      // The booking request has been canceled, and the reserved room are released
    CONFIRMED,      // The booking is confirmed after payment, and the roomNumber are issued
    REFUNDED        // The booking was canceled, and the refund has been processed
}
