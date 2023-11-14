package com.hotel.booking.system.service.repository;

import com.hotel.booking.system.service.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IBookingRepository extends CrudRepository<BookingEntity, UUID> {
}
