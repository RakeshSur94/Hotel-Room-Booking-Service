package com.hotel.booking.system.payment.service.impl;

import com.hotel.booking.system.payment.service.entity.PaymentEntity;
import com.hotel.booking.system.payment.service.paymentgateway.StripePaymentGateway;
import com.hotel.booking.system.payment.service.repository.IPaymentRepository;
import com.hotel.booking.system.payment.service.service.IPaymentService;
import com.movie.ticket.booking.system.commons.constants.LoggerConstants;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import com.movie.ticket.booking.system.commons.dto.BookingStatus;
import com.movie.ticket.booking.system.commons.dto.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class PaymentServiceImpl implements IPaymentService {
    @Autowired
    private IPaymentRepository paymentRepository;
    @Autowired
    private StripePaymentGateway stripePaymentGateway;
    @Override
    @Transactional
    public BookingDTO makePayment(BookingDTO bookingDTO) {
        log.info(LoggerConstants.ENTERED_SERVICE_MESSAGE.getValue(),"make-payment",this.getClass());
        PaymentEntity paymentEntity=PaymentEntity.builder()
                .paymentAmount(bookingDTO.getBookingAmount())
                .paymentStatus(PaymentStatus.PENDING)
                .bookingId(bookingDTO.getBookingId())
                .build();
        //save the payment entity
        this.paymentRepository.save(paymentEntity);
        //make call to the payment gateway
        this.stripePaymentGateway.makePayment(bookingDTO);
        paymentEntity.setPaymentTimeStamp(LocalDateTime.now());
        if(bookingDTO.getBookingStatus().equals(BookingStatus.CONFIRMED)){
            paymentEntity.setPaymentStatus(PaymentStatus.APPROVED);
            bookingDTO.setBookingStatus(BookingStatus.CONFIRMED);
        }
        else{
            paymentEntity.setPaymentStatus(PaymentStatus.FAILED);
            bookingDTO.setBookingStatus(BookingStatus.CANCELLED);

        }
        System.out.println(this.paymentRepository.getClass().getName());

        return bookingDTO;
    }
}
