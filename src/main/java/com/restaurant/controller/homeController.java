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
import com.sun.net.httpserver.Authenticator.Success;

import jakarta.validation.Valid;

@Controller
public class homeController {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private EmailService emailService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("reservation",new Reservation());
		return "index";
	}
	
	@PostMapping("/submitReservation")
	public String handleReservation(@Valid @ModelAttribute Reservation reservation, BindingResult result, Model model) {

	    if (result.hasErrors()) {
	        model.addAttribute("reservation", reservation);
	        return "index";
	    }

	    // 1. Save reservation to DB
	    reservationRepository.save(reservation);

	    // 2. Send confirmation email (IMPORTANT: phone should be email or use separate email field)
	    emailService.sendReservationConfirmation(
	        reservation.getEmail(), // ⚠️ Use getEmail() if phone is not email
	        reservation.getName(),
	        reservation.getReservation_date(),
	        reservation.getTime()
	    );

	    // 3. Show success message
	    model.addAttribute("success", "Your order has been successfully placed!!");

	    // 4. Clear the form
	    model.addAttribute("reservation", new Reservation());

	    return "index";
	}



}
