// Controller for displaying html files in 'templates' folder with Thymeleaf
package com.example.Restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin("*")
public class TemplateController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	   
	@GetMapping("/login")
		public String login() {
			return "login";
		}
	    
	@GetMapping("/register")
		public String register() {
			return "register";
		}
	@GetMapping("/restaurant/profile")
	public String restaurantView() {
		return "restaurantprofile";
	}
	
	@GetMapping("/restaurant/information")
	public String registerRestaurant() {
		return "restaurantinformation";
	}
	
	@GetMapping("/customer/profile")
	public String customerProfile() {
		return "customerprofile";
	}
	
	@GetMapping("/customer/information")
	public String registerCustomer() {
		return "customerinformation";
	}
	
	@GetMapping("/search")
	public String searchFood() {
		return "searchfood";
	}
	
	@GetMapping("/reservation/modify")
	public String modifyReservation() {
		return "restaurantreservation";
	}
}
