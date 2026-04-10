package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    private final String adminEmail = "anshulrathore9009@gmail.com";

    public void sendReservationConfirmation(String toEmail, String name, String date, String time) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("anshulrathore9009@gmail.com");   // ⭐ IMPORTANT
        message.setTo(toEmail);

        // message.setBcc(adminEmail); // optional

        message.setSubject("Your Table Reservation is Confirmed - Grilli Restaurant");

        String emailBody = String.format(
                "Dear %s,\n\n"
                + "Your table reservation at Grilli Restaurant has been successfully confirmed!\n\n"
                + "Date: %s\n"
                + "Time: %s\n\n"
                + "Thank you for choosing Grilli!\n\n"
                + "Grilli Restaurant Team",
                name, date, time
        );

        message.setText(emailBody);

        mailSender.send(message);
    }
}