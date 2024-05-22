//Controller for handling reservations.  Phase 3 code goal
package com.example.Restaurant.controller;

import com.example.Restaurant.models.Customer;
import com.example.Restaurant.models.Reservation;
import com.example.Restaurant.models.ReservationDTO;
import com.example.Restaurant.models.Restaurant;
import com.example.Restaurant.services.CustomerService;
import com.example.Restaurant.services.ReservationService;
import com.example.Restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ReservationController {

    @Autowired
	private ReservationService reservationService;
    
    @Autowired
    private CustomerService customerService;

    @Autowired
    private RestaurantService restaurantService;
    
    @PostMapping("/reserve")
    public Reservation reserve(@RequestBody ReservationDTO body){
    	return reservationService.createReservation(body.getCustomerID(), body.getRestaurantID(), body.getPartySize(), body.getReservationTime(), body.getReservationDate());
    }
    
    @GetMapping("/reservation/{username}/get-all")
    public List<Reservation> getAllUserReservations (@PathVariable String username) {
        username = username.replace("\"", "");
        Customer customer = customerService.getCurrentCustomer(username);
        Integer customerID = customer.getCustomerID();
    	return reservationService.getAllUserReservations(customerID);
    }

    @GetMapping("/restaurant-reservations/{username}")
    public List<Reservation> getAllReservations (@PathVariable String username) {
        username = username.replace("\"", "");
        Restaurant restaurant = restaurantService.getCurrentRestaurant(username);
        Integer restaurantID = restaurant.getRestaurantID();
    	return reservationService.getAllRestaurantReservations(restaurantID);
    }
    
    @GetMapping("/reservation/{reservationID}/details")
	public Reservation getReservationByID(@PathVariable String reservationID) {
		reservationID = reservationID.replace("\"", "");
		return reservationService.getReservationByID(Integer.parseInt(reservationID));
	}

    @PostMapping("/reservation/update-information/{reservationID}")
    public Reservation updateReservation(@RequestBody ReservationDTO body, @PathVariable String reservationID) {
		reservationID = reservationID.replace("\"", "");
        return reservationService.updateReservation(Integer.parseInt(reservationID), body.getPartySize(), body.getReservationTime(), body.getReservationDate());
    }

    @PostMapping("/reservation/cancel/{reservationID}")
    public void cancelReservation(@PathVariable String reservationID) {
		reservationID = reservationID.replace("\"", "");
        reservationService.cancelReservation(Integer.parseInt(reservationID));
    }
}