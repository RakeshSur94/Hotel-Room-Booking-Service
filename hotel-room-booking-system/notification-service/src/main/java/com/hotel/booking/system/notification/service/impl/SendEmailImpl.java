package com.hotel.booking.system.notification.service.impl;

import com.hotel.booking.system.notification.service.mailservice.ISendEmail;
import com.movie.ticket.booking.system.commons.dto.BookingDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class SendEmailImpl implements ISendEmail {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;
    @Override
    public void sendEmail(BookingDTO bookingDTO) {


        try {
            MimeMessage message=javaMailSender.createMimeMessage();//create empty
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(message,true);
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setSubject("Conformation mail from Maa Tarini Hotel .....Its an auto generated mail don't reply");
            mimeMessageHelper.setText("Room Booking "+bookingDTO.getBookingStatus()+ "\n"+"\n"+

                    "Customer Name "+bookingDTO.getCustomerNames().toString()+"\n"+"\n" +
                    "Booking Amount Rupees: "+bookingDTO.getBookingAmount()+"\n"+"\n" +"check in : "+bookingDTO.getCheckIn()+"\n"+"\n" +
                    "check out : "+bookingDTO.getCheckOut()+"\n"+"Thank you for Booking out hotel room");
            mimeMessageHelper.setTo(bookingDTO.getEmailId());
            mimeMessageHelper.setSentDate(new Date());
            mimeMessageHelper.addAttachment("hotel.png",new ClassPathResource("hotel.png"));
            javaMailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
