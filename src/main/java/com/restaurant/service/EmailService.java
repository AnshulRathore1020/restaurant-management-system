package com.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Optional: for admin reference
    private final String adminEmail = "anshulrathore9009@gmail.com";

    public void sendReservationConfirmation(String toEmail, String name, String date, String time) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(toEmail);

        // Optional: BCC admin to keep track
		/* message.setBcc(adminEmail); */

        message.setSubject("✅ Your Table Reservation is Confirmed - Grilli Restaurant");

        String emailBody = String.format(
                "Dear %s,\n\n"
                + "🎉 Your table reservation at Grilli Restaurant has been successfully confirmed!\n\n"
                + "📅 Date: %s\n"
                + "⏰ Time: %s\n\n"
                + "We look forward to serving you with a delightful dining experience.\n"
                + "If you have any questions or need to make changes, feel free to reply to this email.\n\n"
                + "🍽️ Thank you for choosing Grilli!\n\n"
                + "Warm regards,\n"
                + "Grilli Restaurant Team"
                , name, date, time
        );

        message.setText(emailBody);

        mailSender.send(message);
    }
}
