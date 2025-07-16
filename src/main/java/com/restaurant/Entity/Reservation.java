package com.restaurant.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


@Entity

public class Reservation {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
		
	    public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		@NotBlank(message = "Name is required")
	    private String name;
	    
	    
	    @NotBlank(message = "Email is required")
	    @Email(message = "Invalid email format")
	    private String email;

	    
	    
	    @NotBlank(message = "Phone number is required")
	    @Pattern(regexp = "^[0-9]{10}$", message = "Enter valid 10-digit phone number")
	    private String phone;

	    @NotBlank(message="Number of persons is required")
	    private String person;
	    @NotBlank(message="Date is required")
	    private String reservation_date;
	    @Column(name = "reservation_time")
	    @NotBlank(message="Time is required")
	    private String time;
	    
	    private String message;
	 
		public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getReservation_date() {
		return reservation_date;
	}
	public void setReservation_date(String reservation_date) {
		this.reservation_date = reservation_date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
