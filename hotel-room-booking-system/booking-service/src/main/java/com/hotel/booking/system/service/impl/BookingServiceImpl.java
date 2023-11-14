package com.hotel.booking.system.service.impl;

import com.hotel.booking.system.service.entity.BookingEntity;
import com.hotel.booking.system.service.broker.PaymentReceivedApi;
import com.hotel.booking.system.service.kafka.publisher.BookingServiceKafkaPublisher;
import com.hotel.booking.system.service.repository.IBookingRepository;
import com.hotel.booking.system.service.service.IBookingService;
import com.movie.ticket.booking.system.commons.constants.LoggerConstants;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import com.movie.ticket.booking.system.commons.dto.BookingStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private IBookingRepository bookingRepository;


    @Autowired
    private BookingServiceKafkaPublisher bookingServiceKafkaPublisher;

    @Override
    @Transactional
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        log.info(LoggerConstants.ENTERED_SERVICE_MESSAGE.getValue(),"create Booking",this.getClass());
        BookingEntity booking= BookingEntity.builder()
                .bookingAmount(bookingDTO.getBookingAmount())
                .bookingStatus(BookingStatus.PENDING)
                .checkIn(bookingDTO.getCheckIn())
                .checkOut(bookingDTO.getCheckOut())
                .customerNames(bookingDTO.getCustomerNames())
                .emailId(bookingDTO.getEmailId())
                .userId(bookingDTO.getUserId())
                .mobNumber(bookingDTO.getMobNumber())
                .build();
        this.bookingRepository.save(booking); // create a booking with booking status as PENDING
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setBookingStatus(BookingStatus.PENDING);
//        //call the payment service
//        this.paymentReceivedApi.makePayment(bookingDTO);
//        booking.setBookingStatus(bookingDTO.getBookingStatus());
//        return BookingDTO.builder()
//                .bookingId(booking.getBookingId())
//                .bookingAmount(booking.getBookingAmount())
//                .emailId(booking.getEmailId())
//                .mobNumber(booking.getMobNumber())
//                .bookingStatus(booking.getBookingStatus())
//                .userId(booking.getUserId())
//                .checkIn(booking.getCheckIn())
//                .checkOut(booking.getCheckOut())
//                .customerNames(booking.getCustomerNames())
//                .build();
        //Publish the booking to kafka topic
        this.bookingServiceKafkaPublisher.publishTopicToSubscriber(bookingDTO);
        return bookingDTO;
    }
    @Transactional
    @Override
    public void processBooking(BookingDTO bookingDTO) {
        Optional<BookingEntity> bookingEntityOptional = this.bookingRepository.findById(bookingDTO.getBookingId());
        if (bookingEntityOptional.isPresent()) {
            BookingEntity bookingEntity = bookingEntityOptional.get();
            bookingEntity.setBookingStatus(bookingDTO.getBookingStatus());
        }
    }
}
