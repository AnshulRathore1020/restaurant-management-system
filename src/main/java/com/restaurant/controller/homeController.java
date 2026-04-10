package com.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.restaurant.Entity.Reservation;
import com.restaurant.repository.ReservationRepository;
import com.restaurant.service.EmailService;

import jakarta.validation.Valid;

@Controller
public class homeController {


@Autowired
private ReservationRepository reservationRepository;

@Autowired
private EmailService emailService;

// Home Page
@GetMapping("/")
public String index(Model model) {
    model.addAttribute("reservation", new Reservation());
    return "index";
}

// Handle Reservation Form Submit
@PostMapping("/submitReservation")
public String handleReservation(@Valid @ModelAttribute("reservation") Reservation reservation,
                                BindingResult result,
                                Model model) {

    if (result.hasErrors()) {
        return "index";
    }

    reservationRepository.save(reservation);

    new Thread(() -> {
        emailService.sendReservationConfirmation(
            reservation.getEmail(),
            reservation.getName(),
            reservation.getReservation_date(),
            reservation.getTime()
        );
    }).start();

    model.addAttribute("success", "Your reservation has been successfully placed!");

    // Reset form
    model.addAttribute("reservation", new Reservation());

    return "index";
}


}
