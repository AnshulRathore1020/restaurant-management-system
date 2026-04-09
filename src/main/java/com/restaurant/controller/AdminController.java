package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.restaurant.Entity.Reservation;
import com.restaurant.repository.ReservationRepository;

@Controller
public class AdminController {
	
	
	@Autowired
    private  ReservationRepository reservationRepository;

   


    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
    	List<Reservation> reservations = reservationRepository.findAllByOrderByReservation_dateDesc();
        model.addAttribute("reservations", reservations);
        return "admin-dashboard";
    }

    @GetMapping("/admin-login")
    public String login() {
        return "admin-login";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
        return "redirect:/admin/dashboard";
    }
}
