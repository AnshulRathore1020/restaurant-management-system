package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	
}
