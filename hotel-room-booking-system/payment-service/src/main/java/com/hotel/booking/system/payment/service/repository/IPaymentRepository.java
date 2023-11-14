package com.hotel.booking.system.payment.service.repository;

import com.hotel.booking.system.payment.service.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IPaymentRepository extends CrudRepository<PaymentEntity, UUID> {
}
